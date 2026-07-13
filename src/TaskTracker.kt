class TaskTracker {
    var currentXp = 0
    var currentLevel = 1
    var taskList = mutableListOf<Task>()

    /**
     * Creates a new Task using the given name and difficulty, calculates
     * its XP reward based on difficulty, and adds it to the task list.
     * New tasks always start as incomplete.
     *
     * @param name the name of the task
     * @param difficulty the difficulty level of the task ("easy", "medium", or "hard")
     */

    fun addTask(name: String, difficulty: String) {
        val xpReward: Int = when (difficulty) {
            "easy" -> 20
            "medium" -> 40
            "hard" -> 60
            else -> 0
        }

        val isComplete: Boolean = false

        taskList.add(Task(name, difficulty, xpReward, isComplete))
    }

    /**
     * Marks the task at the given index as complete and awards its XP
     * to the player's current XP total. If the resulting XP crosses one
     * or more 100-point thresholds, the player's level increases accordingly.
     * Does nothing if the index is invalid or the task is already complete.
     *
     * @param index the position of the task in the task list (0-based)
     */
    
    fun completeTask(index: Int) {
        // Guard clause: make sure the index is actually valid before touching the list
        if (index < 0 || index >= taskList.size) {
            println("That task number doesn't exist.")
            return
        }

        val task = taskList[index]

        if (task.isComplete) {
            println("That task is already complete.")
            return
        }

        // Mark it done and award XP
        task.isComplete = true
        currentXp += task.xpReward
        println("Task completed! You earned ${task.xpReward} XP.")

        // Leveling logic: every 100 XP is a new level
        // Using a while loop (not if) in case one task's XP jumps you multiple levels
        while (currentXp >= 100) {
            currentXp -= 100
            currentLevel++
            println("Level up! You are now level $currentLevel.")
        }
    }
}