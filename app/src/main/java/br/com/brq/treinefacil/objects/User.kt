package br.com.brq.treinefacil.objects

class User(var login: String, var password: String) {

    fun validaLogin(): Boolean {
        return login == ""
    }

    fun validaSenha(): Boolean {
        return password == ""
    }
}