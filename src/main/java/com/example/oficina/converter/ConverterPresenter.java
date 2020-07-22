/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.converter;

import com.example.oficina.models.Func;
import com.example.oficina.models.Orcamento;
import com.example.oficina.presenter.FuncPresenter;
import com.example.oficina.presenter.OrcPresenter;

/**
 *
 * @author Cast
 */
public class ConverterPresenter {

    public static FuncPresenter convertFuncPresenter(Func response) {
        if (response != null) {
            return convertFuncPresenter(response);
        }
        return null;
    }

    public static OrcPresenter convertOrcPresenter(Orcamento response) {
        if (response != null) {
            return convertOrcPresenter(response);
        }
        return null;
    }

}
