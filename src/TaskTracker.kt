class TaskTracker {
    var currentXp = 0
    var currentLevel = 1
    var taskList = mutableListOf<Task>()

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