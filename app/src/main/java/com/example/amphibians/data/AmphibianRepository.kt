package com.example.amphibians.data

import com.example.amphibians.model.Amphibian

interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}