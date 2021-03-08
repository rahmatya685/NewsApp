package com.newsapp.remo_impl.dto

import com.google.gson.annotations.SerializedName


/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Results (

    @SerializedName("section") val section : String,
    @SerializedName("subsection") val subsection : String,
    @SerializedName("title") val title : String,
    @SerializedName("abstract") val abstract : String,
    @SerializedName("url") val url : String,
    @SerializedName("uri") val uri : String,
    @SerializedName("byline") val byline : String,
    @SerializedName("item_type") val item_type : String,
    @SerializedName("updated_date") val updated_date : String,
    @SerializedName("created_date") val created_date : String,
    @SerializedName("published_date") val published_date : String,
    @SerializedName("material_type_facet") val material_type_facet : String,
    @SerializedName("kicker") val kicker : String,
    @SerializedName("des_facet") val des_facet : List<String>,
    @SerializedName("org_facet") val org_facet : List<String>,
    @SerializedName("per_facet") val per_facet : List<String>,
    @SerializedName("geo_facet") val geo_facet : List<String>,
    @SerializedName("multimedia") val multimedia : List<Multimedia>?,
    @SerializedName("short_url") val short_url : String
)