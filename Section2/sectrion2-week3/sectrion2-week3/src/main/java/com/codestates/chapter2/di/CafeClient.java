package com.codestates.chapter2.di;

import java.util.List;

public class CafeClient{
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceStub() {
            @Override
            public List<Menu> getMenuList() {
                return null;
            }
        };
        MenuController controller = new MenuController(menuService);
        List<Menu> menuList = controller.getMenus();
    }
}
interface MenuService {
    List<Menu> getMenuList();
}
class MenuController{
    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }
    public List<Menu> getMenus(){
        return menuService.getMenuList();
    }
}

class MenuServiceStub implements MenuService {
    @Override
    public List<Menu> getMenuList() {
        return List.of(
                new Menu(1, "아메리카노", 2500),
                new Menu(2, "카라멜 마끼야또", 4500),
                new Menu(3, "바닐라 라떼", 4500)
        );
    }
}

class Menu {
    private long id;
    private String name;
    private int price;

    public Menu(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

