package zieunx.module;

import zieunx.module.service.ActiveService;

public class Main {
    public static void main(String[] args) {
        ActiveService activeService = new ActiveService();
        activeService.run();
    }
}
