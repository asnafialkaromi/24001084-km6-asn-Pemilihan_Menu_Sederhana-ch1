package app.datasource

import app.model.DetailsMenu

interface MenuDataSource {
    fun getMenuList() : List<DetailsMenu>
}

class MenuDataSourceImp() : MenuDataSource {
    override fun getMenuList(): List<DetailsMenu> {
        return listOf(
            DetailsMenu(
                menuName = "Ayam Bakar",
                menuPrice = 50000
            ),
            DetailsMenu(
                menuName = "Ayam Goren",
                menuPrice = 40000
            ),
            DetailsMenu(
                menuName = "Ayam Geprek",
                menuPrice = 40000
            ),
            DetailsMenu(
                menuName = "Kulit Ayam Crispy",
                menuPrice = 15000
            ),
            DetailsMenu(
                menuName = "Sate Usus Ayam",
                menuPrice = 5000
            ),
        )
    }
}