package com.samsung.hiddenbandselection

import java.io.DataOutputStream

object RootUtils {
    fun runAsRoot(command: String) {
        try {
            val process = Runtime.getRuntime().exec("su")
            val outputStream = DataOutputStream(process.outputStream)

            outputStream.writeBytes("$command\n")
            outputStream.writeBytes("exit\n")
            outputStream.flush()
            process.waitFor()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
