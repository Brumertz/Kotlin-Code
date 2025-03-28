package carcollection

import java.io.Serializable

/**
 * Car class representing a vehicle with attributes like make, model, year, and odometer reading.
 * Implements Serializable to enable binary file storage.
 */
class Car : Serializable {
    var make: String
    var model: String?
    var year: String?
    var odometer: Int

    // Primary constructor
    constructor(make: String) {
        this.make = make
        this.model = null
        this.year = null
        this.odometer = 0
    }

    // Secondary constructor
    constructor(make: String, model: String?, year: String?, odometer: Int) {
        this.make = make
        this.model = model
        this.year = year
        this.odometer = odometer
    }

    /**
     * Displays the car details.
     */
    fun display() {
        println("Make: $make | Model: ${model ?: "Unknown"} | Year: ${year ?: "Unknown"} | Odometer: $odometer km")
    }
}