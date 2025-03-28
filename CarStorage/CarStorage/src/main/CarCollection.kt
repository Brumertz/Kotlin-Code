import carcollection.Car
import java.io.*
import java.util.Scanner
import kotlin.system.exitProcess


/**
 * CarCollection class that manages a collection of Car objects.
 */
object CarCollection {
    private val cars = ArrayList<Car>()
    private const val FILE_NAME = "cars.dat"
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        loadCarsFromFile()
        while (true) {
            displayMenu()
            val choice = getIntInput()
            when (choice) {
                1 -> displayCars()
                2 -> sortCarsByMake()
                3 -> searchCarByMake()
                4 -> addCar()
                5 -> saveCarsToFile()
                6 -> loadCarsFromFile()
                7 -> exitProgram()
                else -> println("Invalid choice. Please try again.")
            }
        }
    }

    /**
     * Displays the menu for user interaction.
     */
    private fun displayMenu() {
        println("\n=== Car Collection Menu ===")
        println("1. Display all car details")
        println("2. Sort cars by make")
        println("3. Search for a car by make")
        println("4. Add a new car")
        println("5. Save cars to binary file")
        println("6. Load cars from file")
        println("7. Exit")
        print("Enter your choice: ")
    }

    /**
     * Displays all cars in the collection.
     */
    private fun displayCars() {
        if (cars.isEmpty()) {
            println("No cars available.")
            return
        }
        cars.forEach { it.display() }
    }

    /**
     * Sorts cars by their make using Kotlin's sortBy() method.
     */
    private fun sortCarsByMake() {
        if (cars.isEmpty()) {
            println("No cars available to sort.")
            return
        }
        cars.sortBy { it.make }
        println("Cars sorted by make.")
        displayCars()
    }

    /**
     * Searches for a car by its make.
     */
    private fun searchCarByMake() {
        print("Enter car make to search: ")
        val make = scanner.nextLine().trim()
        val foundCars = cars.filter { it.make.equals(make, ignoreCase = true) }

        if (foundCars.isEmpty()) {
            println("No cars found with make: $make")
        } else {
            println("Cars matching '$make':")
            foundCars.forEach { it.display() }
        }
    }

    /**
     * Adds a new car to the collection.
     */
    private fun addCar() {
        print("Enter car make: ")
        val make = scanner.nextLine().trim()
        print("Enter car model: ")
        val model = scanner.nextLine().trim()
        print("Enter car year: ")
        val year = scanner.nextLine().trim()
        print("Enter odometer reading: ")
        val odometer = getIntInput()

        cars.add(Car(make, model, year, odometer))
        println("Car added successfully!")
    }

    /**
     * Saves the car collection to a binary file.
     */
    private fun saveCarsToFile() {
        try {
            ObjectOutputStream(FileOutputStream(FILE_NAME)).use { it.writeObject(cars) }
            println("Car data saved successfully.")
        } catch (e: IOException) {
            println("Error saving car data: ${e.message}")
        }
    }

    /**
     * Loads car data from a binary file.
     */
    @Suppress("UNCHECKED_CAST")
    private fun loadCarsFromFile() {
        val file = File(FILE_NAME)
        if (!file.exists()) {
            println("No saved data found.")
            return
        }

        try {
            ObjectInputStream(FileInputStream(FILE_NAME)).use {
                val loadedCars = it.readObject() as? ArrayList<Car>
                if (loadedCars != null) {
                    cars.clear()
                    cars.addAll(loadedCars)
                    println("Car data loaded successfully.")
                }
            }
        } catch (e: IOException) {
            println("Error loading car data: ${e.message}")
        } catch (e: ClassNotFoundException) {
            println("Error: Data format is incorrect.")
        }
    }

    /**
     * Exits the program after saving the data.
     */
    private fun exitProgram() {
        saveCarsToFile()
        println("Exiting program. Data saved.")
        scanner.close()
        exitProcess(0)
    }

    /**
     * Safely gets an integer input from the user.
     */
    private fun getIntInput(): Int {
        while (true) {
            try {
                val input = scanner.nextLine().trim()
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a valid number.")
            }
        }
    }
}
