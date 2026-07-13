fun main() {
    print("Enter name: ")
    val name = readln()

    val tracker = TaskTracker()

    println("Welcome! $name, you have ${tracker.currentXp} XP.")

    println("Do you wish to continue?")
    println("1. Add a task")
    println("2. Complete a task")
    println("3. Exit")

    var userChoice = readln()

    while (userChoice != "3") {
        when (userChoice) {
            "1" -> {
                print("Enter Task Name: ")
                val taskName = readln()

                print("Enter Task Difficulty (Easy, Medium, Hard): ")
                val taskDifficulty = readln().lowercase()

                tracker.addTask(taskName, taskDifficulty)
                println("Task added successfully!")
            }
            "2" -> {
                if (tracker.taskList.isEmpty()) {
                    println("You have no tasks yet.")
                } else {
                    println("========== TASK LIST ==========")
                    for ((i, taskItem) in tracker.taskList.withIndex()) {
                        val status = if (taskItem.isComplete) "DONE" else "NOT DONE"
                        println("${i + 1}. ${taskItem.taskName} (${taskItem.difficulty}) - $status")
                    }

                    print("Enter the number of the task to complete: ")
                    val choice = readln().toIntOrNull()

                    if (choice == null) {
                        println("That's not a valid number.")
                    } else {
                        // Subtract 1 since the user sees 1-based numbers but the list is 0-based
                        tracker.completeTask(choice - 1)
                    }
                }
            }
            else -> println("Invalid choice, please enter 1, 2, or 3.")
        }

        println()
        println("Current XP: ${tracker.currentXp} | Level: ${tracker.currentLevel}")
        println()
        println("Do you wish to continue?")
        println("1. Add a task")
        println("2. Complete a task")
        println("3. Exit")

        userChoice = readln()
    }

    println()
    println("========== FINAL TASK LIST ==========")
    for (taskItem in tracker.taskList) {
        println("Task Name: ${taskItem.taskName}")
        println("Difficulty: ${taskItem.difficulty}")
        println("XP Reward: ${taskItem.xpReward}")
        println("Completed: ${taskItem.isComplete}")
        println()
    }

    println("Final Level: ${tracker.currentLevel}")
    println("Final XP: ${tracker.currentXp}")
    println("Goodbye!")
}