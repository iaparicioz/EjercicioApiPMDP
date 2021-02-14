package com.example.ejercicioapipmdp

data class Cocktails (
    var isDrink: String,
    var strDrink: String,
    var strDrinkAlternative: String,
    var strDrinkES: String,
    var strDrinkDE: String,
    var strDrinkFR: String,
    var strDrinkZHHANS: String,
    var strDrinkZHHANT: String,
    var strTags: String,
    var strVideo: String,
    var strCategory: String,
    var strAlcoholic: String,
    var strGlass: String,
    var strInstructions: String,
    var strInstructionES: String,
    var strInstructionsDE: String,
    var strInstructionsFR: String,
    var strInstructionsZHHANS: String,
    var strInstructionsZHHANT: String,
    var strDrinkThumb: String,
    var strIngredient1: String,
    var strMeasure1: String,
    var strImageSource: String,
    var strImageAttribution: String,
    var strCreativeCommonsCorfimed: String,
    var dateModified: String,
){
    override fun toString(): String {
        return "\nNombre bebida: $strDrink\nEmpresa:$strTags\n¿Con alcohol?:$strAlcoholic\n================="
    }
}

