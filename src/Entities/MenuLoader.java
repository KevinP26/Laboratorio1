package Entities;

import java.util.List;

public class MenuLoader {

    public static FoodMenu getMenuComidaNormal() {
        return new FoodMenu("Menú Normal", List.of(
                new Food("Cangreburguer con Queso", "La clásica con queso"),
                new Food("Cangreburguer Doble", "Doble carne, doble sabor"),
                new Food("Papas Fondo de Bikini", "Crujientes y doradas"),
                new Food("Combo Sencillo", "Hamburguesa + papas + bebida")
        ));
    }

    public static FoodMenu getMenuComidaEmpresarial() {
        return new FoodMenu("Menú Empresarial", List.of(
                new Food("Cangreburguer Ejecutiva", "Versión premium con ingredientes seleccionados"),
                new Food("Ensalada Oceánica Deluxe", "Ligera y elegante"),
                new Food("Fondo Marino Especial", "Plato gourmet del chef"),
                new Food("Combo Empresarial Gold", "Combo completo con bebida y postre")
        ));
    }

    public static DrinkMenu getMenuBebidasNormal() {
        return new DrinkMenu("Bebidas Normales", List.of(
                new Drink("Refresco de Kelp", "Refrescante bebida local"),
                new Drink("Jugo de Medusa", "Ácido y natural"),
                new Drink("Agua Salada Filtrada", "Saludable y limpia"),
                new Drink("Batido de Coral", "Dulce y cremoso")
        ));
    }

    public static DrinkMenu getMenuBebidasEmpresarial() {
        return new DrinkMenu("Bebidas Empresariales", List.of(
                new Drink("Café Fondo de Bikini", "Intenso y aromático"),
                new Drink("Té de Algas Premium", "Refinado y saludable"),
                new Drink("Agua Desionizada de Lujo", "Súper purificada"),
                new Drink("Batido Ejecutivo de Coral", "Exclusivo y energizante")
        ));
    }
}
