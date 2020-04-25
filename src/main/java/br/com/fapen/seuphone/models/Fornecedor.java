package br.com.fapen.seuphone.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Fornecedor {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
    private Long id;

    @Column(name = "razao_social")
    private String razaoSocial;
    
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "tel_fornecedor")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "categoria_produto")
    private String categoriaProduto;

    @Column(name = "inativo")
    private int inativo;

    @OneToOne
    private Endereco endereco;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoriaProduto() {
        return this.categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getInativo() {
        return this.inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", razaoSocial='" + razaoSocial + "'" +
            ", cnpj='" + cnpj + "'" +
            ", tel='" + tel + "'" +
            ", email='" + email + "'" +
            ", categoriaProduto='" + categoriaProduto + "'" +
            ", inativo='" + inativo + "'" +
            "}";
    }
    

}