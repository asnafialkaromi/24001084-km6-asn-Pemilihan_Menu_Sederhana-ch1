package app

import app.datasource.MenuDataSourceImp

class App {

    private val listMenu = MenuDataSourceImp().getMenuList()

    private var selectedMenu: String? = null
    private var priceMenu: Int = -1
    private var selectedMethod: Int = 0

    private fun printMenu() {
        println(
            """
            ===================================
            Selamat Datang di warung Binar
            ===================================
            List menu makanan :
        """.trimIndent()
        )
        listMenu.forEachIndexed { index, data ->
            println("${index + 1}. ${data.menuName} = Rp. ${data.menuPrice}/Porsi")
        }

    }

    private fun getSelectedMenu() {
        print("\nPilih menu makanan : ")
        try {
            val selectedNumber = readln().toInt()
            println("--------------------------")
            if (selectedNumber in 1..listMenu.size) {
                selectedMenu = listMenu[selectedNumber - 1].menuName
                priceMenu = listMenu[selectedNumber - 1].menuPrice
                println(
                    """
                    Kamu memilih menu $selectedNumber
                    Nama Menu : $selectedMenu
                    Harga     : Rp. $priceMenu
                """.trimIndent()
                )
            } else {
                println("Menu tidak ada")
                getSelectedMenu()
            }
        } catch (e: NumberFormatException) {
            println("Anda salah dalam memilih menu, coba lagi")
            getSelectedMenu()
        }
    }

    private fun validatePayment() {
        print("Masukkan Pembayaran : ")
        try {
            val amount = readln().toInt()
            if (amount >= priceMenu) {
                println("Terima kasih, Anda berhasil memesan makanan\n")
            } else {
                println("Maaf, pembayaran anda gagal, silahkan coba lagi\n")
                validatePayment()
            }
        } catch (e: NumberFormatException) {
            println("Maaf, pembayaran anda gagal, silahkan coba lagi\n")
            validatePayment()
        }
    }

    private fun deliveryMethod() {
        print(
            """
            Metode Pengiriman Makanan :
            1. Take Away
            2. Delivery
            Pilih metode pengiriman : 
        """.trimIndent()
        )
        try {
            selectedMethod = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Anda salah dalam memilih metode pengiriman, silahkan coba lagi")
            deliveryMethod()
        }
    }

    private fun deliveryProcess() {
        when (selectedMethod) {
            1 -> {
                println("\nMakananmu sedang dimasak (5 detik).....")
                Thread.sleep(5000)
                println("Makananmu sudah siap! silahkan ambil di resto ya! (5 detik).....")
                Thread.sleep(5000)
                println("Pesanan selesai! (3 detik)...")
                Thread.sleep(3000)
            }

            2 -> {
                println("\nMakananmu sedang dimasak (5 detik).....")
                Thread.sleep(5000)
                println("Makananmu sudah siap! Driver sedang menuju tempatmu! (5 detik).....")
                Thread.sleep(5000)
                println("Driver sampai! Pesanan selesai! (3 detik)...")
                Thread.sleep(3000)
            }

            else -> {
                println("Metode pengiriman yang anda pilih tidak ada, silahkan coba lagi")
                deliveryMethod()
            }
        }
    }

    fun run() {
        printMenu()
        getSelectedMenu()
        validatePayment()
        deliveryMethod()
        deliveryProcess()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}