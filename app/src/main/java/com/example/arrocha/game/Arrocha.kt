package com.example.arrocha.game


class Arrocha (var menor: Int, var maior:Int) {
    var sorteio: Int
    var status: Status

    init {
        this.sorteio = ((this.menor + 1) until (this.maior - 1)).random()
        this.status = Status.EXECUTANDO
    }

    fun arrochado(): Boolean{
        return this.menor + 1 == this.maior - 1
    }

    fun validate(chute: Int): Boolean {
        return chute > this.menor && chute < this.maior && chute != this.sorteio
    }

    fun updateInterval(chute: Int): Int{
        if (chute < this.sorteio){
            this.menor = chute
            return -1
        }else{
            this.maior = chute
            return 1
        }
    }

    fun play(chute: Int): Int{
        if (!this.validate(chute)) {
            this.status = Status.PERDEU
            return 0
        }
        else{
            var valor = this.updateInterval(chute)
            if (this.arrochado()){
                this.status = Status.GANHOU
            }
            return valor
        }
    }
}