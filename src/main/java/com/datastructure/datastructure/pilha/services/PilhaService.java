package com.datastructure.datastructure.pilha.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.datastructure.datastructure.pilha.repositories.PilhaRepository;

@Service
public class PilhaService {

    private static int capacidade = 5;

    private static PilhaRepository<Integer> pilha;

    public void push(Integer valor) throws Exception {
        if (pilha == null) {
            pilha = new PilhaRepository<>(capacidade);
        }
        pilha.push(valor);
    };

    public Integer pop() throws Exception {
        return pilha.pop();
    };

    public Integer getTamanho() throws Exception {
        return pilha.tamanho();
    };

    public Integer getTopo() throws Exception {
        return pilha.getTopo();
    };

    public Boolean vazia() throws Exception {
        return pilha.vazia();
    };

    public Map<String, Object> getPilha() throws Exception {
        Object[] elementosGenericos = pilha.getElementos();
        Integer[] elementosInteger = new Integer[elementosGenericos.length];

        for (int i = 0; i < elementosGenericos.length; i++) {
            elementosInteger[i] = (Integer) elementosGenericos[i];
        }

        var topo = this.getTopo();
        Map<String, Object> response = new HashMap<>();
        response.put("lista", elementosInteger);
        response.put("topo", topo);

        return response;
    }

    public Object[] getPilha12() throws Exception {
        return pilha.getElementos();
    }

    public static void setCapacidade(int capacidade) {
        PilhaService.capacidade = capacidade;
        pilha = new PilhaRepository<>(capacidade);
    }

    public void exibir() {
        System.out.println(pilha.toString());
    }
}
