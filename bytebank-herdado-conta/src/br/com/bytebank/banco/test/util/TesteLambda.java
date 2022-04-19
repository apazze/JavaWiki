package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteLambda {

	public static void main(String[] args) {
		
		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);
		
		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);
		
		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);
		
		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		
		// Para ordenar obejtos da minha classe (Ex. Conta) tenho que implementar a interface Comparator
		// Para sobrescrever o metodo Compare para dizer qual dos meus atributos que sera o de avaliação para esta ordenação
		// Como o uso desta classe sera somente para este fim, ao inves de criar uma classe, podemos passar ela como parametro,
		// tornando-se uma classe anonima... Mas ainda será implementado os lambdas que enxugam ainda mais esse processo...
		
		lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) ); // lambda
		
		Comparator<Conta> comp = (Conta c1, Conta c2) -> {
				String nomeC1 = c1.getTitular().getNome();
				String nomeC2 = c2.getTitular().getNome();
				return nomeC1.compareTo(nomeC2);
		};
		
		lista.sort( comp );
		
		//outro lambda
		
		//Forma 1 mais explicita:
		
		lista.forEach(new Consumer<Conta>() {

			@Override
			public void accept(Conta conta) {
				System.out.println(conta + ", " + conta.getTitular().getNome());
			}
		});
		
		
		//Forma 2 implicita moderna
		
		lista.forEach( (conta) -> System.out.println(conta + ", " + conta.getTitular().getNome()));
		
		
		
		//List<String> nomes = new ArrayList<>();
//		nomes.add("Super Mario");
//		nomes.add("Yoshi"); 
//		nomes.add("Donkey Kong"); 
//
//		Collections.sort(nomes, new Comparator<String>() {
//
//		    @Override
//		    public int compare(String s1, String s2) {
//		        return s1.length() - s2.length();
//		    }
//		});
//
//		System.out.println(nomes);
		
		//nomes.sort((s1, s2) ->  {return s1.length() - s2.length();} );
		
		//Collections.sort(nomes, (s1, s2) ->  s1.length() - s2.length());
		
		
		
		//N maneiras de iterar uma lista
		
		List<String> nomes = new ArrayList<>();
		nomes.add("Super Mario");
		nomes.add("Yoshi"); 
		nomes.add("Donkey Kong"); 
		
		
		//1:
		for(int i = 0; i < nomes.size(); i++) {
		    System.out.println(nomes.get(i));
		}
		
		
		//2:
		for (Iterator<String> i = nomes.iterator(); i.hasNext();) {
		    String nome = i.next();
		    System.out.println(nome);
		}
		
		//3:
		
		for (String nome : nomes) {
		    System.out.println(nome);
		}
		
		//4:
		
		for(int i = 0; i < nomes.size(); i++) {
		    System.out.println(nomes.get(i));
		}
		
		
		//5: com LAMBDAS
		
		nomes.forEach((nome) -> System.out.println(nome));
		
		
		
		//vimos ArrayList, LinkedList e Vector
		
		//Existem ainda as coleções
		
		//fila (Queue), conjunto (Set) e mapa (Map)
		
		//Como posso acessar (iterar) todas essas implementações de maneira uniforme sem saber os detalhes de cada implementação? 
		//A resposta está na "caixa de padrões de projeto" e se chama Iterator.
		
		//Uma Iterator é um objeto que possui no mínimo dois métodos: hasNext()e next(). 
//		Ou seja, você pode usá-lo para perguntar se existe um próximo elemento e pedir o próximo elemento. 
//		A notícia boa é que isso funciona com TODAS as implementações e aí a grande vantagem.
		
		List<String> nomes = new ArrayList<>();
		nomes.add("Super Mario");
		nomes.add("Yoshi"); 
		nomes.add("Donkey Kong"); 

		Iterator<String> it = nomes.iterator();

		while(it.hasNext()) {
		  System.out.println(it.next());
		}
		
		
		//Ou com set
		
		Set<String> nomesSet = new HashSet<>();
		nomesSet.add("Super Mario");
		nomesSet.add("Yoshi"); 
		nomesSet.add("Donkey Kong"); 

		Iterator<String> it = nomesSet.iterator();

		while(it.hasNext()) {
		  System.out.println(it.next());
		}
		
		
	}
}

