package org.example.opp

class BankAccount {
    private var balance: Double = 0.0 // Thuộc tính private, đóng gói
        private set // Setter là private, chỉ có thể thay đổi balance từ bên trong lớp

    val currentBalance: Double // Thuộc tính public chỉ đọc để lấy balance
        get() = balance

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Đã nạp $amount. Số dư mới: $balance")
        } else {
            println("Số tiền nạp không hợp lệ.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Đã rút $amount. Số dư mới: $balance")
        } else {
            println("Số tiền rút không hợp lệ hoặc không đủ số dư.")
        }
    }
}

fun main() {
    val myAccount = BankAccount()
    // println(myAccount.balance) // Lỗi! 'balance' là private
    println("Số dư ban đầu: ${myAccount.currentBalance}") // 0.0

    myAccount.deposit(100.0)    // Đã nạp 100.0. Số dư mới: 100.0
    myAccount.withdraw(30.0)     // Đã rút 30.0. Số dư mới: 70.0
    // myAccount.balance = 50.0 // Lỗi! Setter của balance là private
}