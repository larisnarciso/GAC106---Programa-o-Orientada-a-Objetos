/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.CarroFactory;
import fabricaautomoveis.ChevroletFactory;
import fabricaautomoveis.FiatFactory;
import fabricaautomoveis.VWFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        CarroFactory factory = new ChevroletFactory();
        ppooVeiculos = new Concessionaria("PPOO Veículos", Marca.Chevrolet, factory);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    switch (menuFranquia()){
                        case 1:
                            mudarFranquia(Marca.Chevrolet);
                            break;
                        case 2:
                            mudarFranquia(Marca.FIAT);
                            break;
                        case 3:
                            mudarFranquia(Marca.VW);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar Franquia");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private int menuFranquia(){
        System.out.println("1 - Chevrolet");
        System.out.println("2 - Fiat");
        System.out.println("3 - VW");

        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }

    private void esperarTecla() {
        entrada.nextLine();
    }

    /**
     * Método para mudar a marca da franquia da concessionária
     * @param marca
     */

    private void mudarFranquia(Marca marca){
        CarroFactory factory;
        
        if(marca == Marca.Chevrolet){
            factory = new ChevroletFactory();
            ppooVeiculos.SetFactory(factory);
        }else if(marca == Marca.FIAT){
            factory = new FiatFactory();
            ppooVeiculos.SetFactory(factory);
        }else if(marca == Marca.VW){
            factory = new VWFactory();
            ppooVeiculos.SetFactory(factory);
        }
    }
}