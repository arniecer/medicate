package com.medicate.app.ui.screens.tratamientos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.medicate.app.ui.theme.MedicateTheme

@Composable
fun AddMedicationScreen(onSave: (String) -> Unit) {
    var name by rememberSaveable { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Añadir medicamento")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") }
        )
        Button(
            onClick = { onSave(name.trim()) },
            enabled = name.isNotBlank()
        ) {
            Text("Guardar medicamento")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddMedicationScreenPreview() {
    MedicateTheme {
        AddMedicationScreen(onSave = {})
    }
}
