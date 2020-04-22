package br.com.fapen.seuphone.models;

public class Fornecedor {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String tel;
    private String email;
    private String categoriaProduto;
    private int inativo;


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