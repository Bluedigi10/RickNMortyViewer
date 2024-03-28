package com.bluedigi.ricknmortyviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.bluedigi.ricknmortyviewer.model.Character
import com.bluedigi.ricknmortyviewer.ui.theme.CharacterDetail
import com.bluedigi.ricknmortyviewer.ui.theme.CharacterViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CharacterList(viewModel)
            }
        }
        viewModel.loadCharacters()
    }
}

@Composable
fun CharacterList(viewModel: CharacterViewModel) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn {
        items(characters.size) { index ->
            CharacterItem(character = characters[index], viewModel)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterItem(character: Character, viewModel: CharacterViewModel) {
    var expanded by remember { mutableStateOf(false) }

    // Observar cambios en characterDetail
    val characterDetail by viewModel.characterDetail.collectAsState()

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier.size(64.dp)
            )
            Text(
                text = character.name,
                modifier = Modifier.padding(start = 16.dp)
            )
            Button(
                onClick = {
                    expanded = !expanded
                    if (expanded && characterDetail == null) {
                        viewModel.loadCharacterDetail(character.id)
                    }
                }
            ) {
                Text(if (expanded) "Ocultar detalle" else "Ver detalle")
            }
        }

        // Mostrar detalles del personaje si expanded es verdadero y characterDetail no es nulo
        if (expanded && characterDetail != null) {
            characterDetail?.let {
                CharacterDetail(it)
            }
        }
    }
}


