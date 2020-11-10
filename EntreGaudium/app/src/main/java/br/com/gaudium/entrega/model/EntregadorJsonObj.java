package br.com.gaudium.entrega.model;

import java.util.List;


public class EntregadorJsonObj {

    private Response response;
    private String success;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public class Response {
        private String nome;
        private String cargo;
        private String descricao;
        private List<Historico> historico;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public List<Historico> getHistorico() {
            return historico;
        }

        public void setHistorico(List<Historico> historico) {
            this.historico = historico;
        }
    }


}
