package DAO;

import Model.bo.Bairro;
import Model.bo.Carteirinha;
import Model.bo.Cidade;
import Model.bo.Cliente;
import Model.bo.Endereco;
import Model.bo.Fornecedor;
import Model.bo.Produto;
import Model.bo.funcionario;
import java.util.ArrayList;


public class ClasseDados {
    
    private static ClasseDados instance;
    public static ArrayList<Bairro> listaBairro;
    public static ArrayList<Fornecedor> listaFornecedor;
    public static ArrayList<Cidade> listaCidade;
    public static ArrayList<Endereco> listaEndereco;
    public static ArrayList<Cliente> listaCliente;
    public static Endereco endereco;
    public static ArrayList<Produto> listaProduto;
    public static ArrayList<Carteirinha> listaCarteirinha;
    public static ArrayList<funcionario> listaFuncionario;
    
    public static synchronized ClasseDados getInstance(){
    
    if(instance == null){
        instance = new ClasseDados();
    }
    return instance;
}

    private ClasseDados() {
        endereco = new Endereco();
        listaFornecedor = new ArrayList();
        listaBairro = new ArrayList();
        listaCidade = new ArrayList();
        listaEndereco = new ArrayList();
        listaCliente = new ArrayList();
        listaProduto = new ArrayList();
        listaCarteirinha = new ArrayList();
        listaFuncionario = new ArrayList();
        
        Bairro bairro = new Bairro(1,"centro");
        Bairro bairro1 = new Bairro(2,"casa");
        Bairro bairro2= new Bairro(3,"trabalho");

        Cidade cidade = new Cidade(1, "SM", "sc");
        Cidade cidade1 = new Cidade(2,"TB", "sc");
        Cidade cidade2 = new Cidade(3, "BN", "sc");
        
        Endereco endereco = new Endereco(1,"88765000", "centro","a", bairro, cidade);
        Endereco endereco1 = new Endereco(2,"88765000", "Estra Geral","a", bairro1, cidade1);
        Endereco endereco2 = new Endereco(3,"88765000", "centro","a", bairro2, cidade2);
       
        Cliente cliente = new Cliente("123123123", "123123123", "123123123", "1807200", 1, "Luiz", "48996558607", "48996558607", "luizfernandopreis4@gmail.com", "a", "casa", endereco);
        Cliente cliente1 = new Cliente("123123123", "123123123", "123123123", "1807200", 2, "Gabriel", "48996558607", "48996558607", "luizfernandopreis4@gmail.com", "a", "casa", endereco1);
        Cliente cliente2= new Cliente("123123123", "123123123", "123123123", "1807200", 3, "David", "48996558607", "48996558607", "luizfernandopreis4@gmail.com", "a", "casa", endereco2);
        
        Carteirinha carteirinha = new Carteirinha(1, "123123", "18072021", "18072022",cliente);
        Carteirinha carteirinha1 = new Carteirinha(2, "123123", "18082023", "18082024",cliente1);
        Carteirinha carteirinha2 = new Carteirinha(3, "123123", "18092020", "18092021",cliente2);
        
        funcionario Funcionario = new funcionario("123123","123123","luiz","123123",1,"luiz fernando", "1231231230","48123123123", "a@gmail.com", "a","casa do juninho", endereco);
        funcionario Funcionario1 = new funcionario("123123","123123","guilherme","123123",2,"luiz fernando", "1231231230","48123123123", "a@gmail.com", "a","casa do juninho", endereco);
        funcionario Funcionario2 = new funcionario("123123","123123","gabriel","123123",3,"luiz fernando", "1231231230","48123123123", "a@gmail.com", "a","casa do juninho", endereco);
                
        Fornecedor fornecedor = new Fornecedor("123456123", "sim", "casado", 1, "Garcia", "998696969", "998969696", "garcia@gmail.com", "a", "casa do caralho", endereco);
        Fornecedor fornecedor1 = new Fornecedor("123456123", "sim", "casado", 2, "Diniz", "998696969", "998969696", "garcia@gmail.com", "a", "casa do caralho", endereco1);
        Fornecedor fornecedor2 = new Fornecedor("123456123", "sim", "casado", 3, "Luiz", "998696969", "998969696", "garcia@gmail.com", "a", "casa do caralho", endereco2);

        listaBairro.add(bairro);
        listaBairro.add(bairro1);
        listaBairro.add(bairro2);
        
        listaFornecedor.add(fornecedor);
        listaFornecedor.add(fornecedor1);
        listaFornecedor.add(fornecedor2);
        
        listaCidade.add(cidade);
        listaCidade.add(cidade1);
        listaCidade.add(cidade2);
        
        listaEndereco.add(endereco);
        listaEndereco.add(endereco1);
        listaEndereco.add(endereco2);
        
        listaCliente.add(cliente);
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        
        listaCarteirinha.add(carteirinha);
        listaCarteirinha.add(carteirinha1);
        listaCarteirinha.add(carteirinha2);
    
       listaFuncionario.add(Funcionario);
       listaFuncionario.add(Funcionario1);
       listaFuncionario.add(Funcionario2);
    }
}
