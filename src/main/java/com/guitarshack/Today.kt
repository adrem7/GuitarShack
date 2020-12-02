package com.guitarshack

import main.CurrentDate
import java.util.*

class Today : CurrentDate {
    override fun get(): Date {
        return Calendar.getInstance().time
    }
}