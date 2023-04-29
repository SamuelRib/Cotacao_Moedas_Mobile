package com.sam.cotacao_moedas.model



data class ParMoeda(
    val USDBRL: Moeda,
    val BTCBRL: Moeda
)
data class Moeda (
    //var USDBRL: String?= null,
    val code: String,
    val codein: String?= null,
    val name: String? = null,
    val high: String? = null,
    val low: String? = null,
    val varBid: String,
    val pctChange: String,
    val bid: String,
    val ask: String? = null,
    val timestamp: String,
    val create_date: String? = null
        )
/*
"USDBRL": {
        "code": "USD",
        "codein": "BRL",
        "name": "Dólar Americano/Real Brasileiro",
        "high": "5.734",
        "low": "5.7279",
        "varBid": "-0.0054",
        "pctChange": "-0.09",
        "bid": "5.7276",
        "ask": "5.7282",
        "timestamp": "1618315045",
        "create_date": "2021-04-13 08:57:27"
 */