package org.skypro.skyshop.exeptions;

import java.io.IOException;

public class BestResultNotFound extends Exception {

    private String search;

    public BestResultNotFound(String search) {
        super ();
        this.search = search;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{" + "по запросу '" + search + "' ничего не найдено}";
    }

}
