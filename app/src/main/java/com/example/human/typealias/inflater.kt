package com.example.human.`typealias`

import android.view.LayoutInflater
import android.view.ViewGroup

typealias Inflater<T> = (
    inflater: LayoutInflater, view: ViewGroup?,
    attach: Boolean
) -> T