cadastrar = async () =>{
    let id = document.getElementById("id").value
    let produto // pokemon
    let verbo
    if (id) {
        produto = { // ATUALIZAÇÃO
            id: id,
            nome: document.getElementById("nome").value,
            especificacao: document.getElementById("especificacao").value,
            valor: Number(document.getElementById("valor").value),
            quantidade: Number(document.getElementById("quantidade").value)
        }
        verbo = 'PUT'
    }
    else { // CADASTRO
        produto = {
            nome: document.getElementById("nome").value,
            especificacao: document.getElementById("especificacao").value,
            valor: Number(document.getElementById("valor").value),
            quantidade: Number(document.getElementById("quantidade").value)
        }
        verbo = 'POST'
    }
  
    await fetch('http://localhost:8080/produtos', {
        method: verbo, //Metodo Post 
        body: JSON.stringify(produto), // Convertendo o dado para string
        headers: {'Content-Type': 'application/json; charset=UTF-8'} // Cabeçalho da requisição mostrando que tipo JSON 
    })
    .then(Response => {// resposta retornada do servidor
        alert('Produto Cadastrado com Sucesso')
    })
    .catch(error => { // veio um erro de resposta do servidor ...
        alert('Problema no cadastro do Produto')
    })
    consulta() // atualiza a tabela, consultando no servidor API
}

consulta = async () => {
    let produtos = await fetch('http://localhost:8080/produtos')
    .then(Response => {
            //retorna os dados do servidor para tipo json para produtos
        return Response.json()
    })
    .catch(error => {
        alert('Problema na consulta')
    })

    let saida = ''
    produtos.map(produto => {
        saida += `<tr> <td> ${produto.nome} </td> <td> ${produto.especificacao} </td><td> ${produto.valor} </td> <td> ${produto.quantidade}</td> <td>  <i onClick="remove(${produto.id})" class="bi bi-trash-fill"></i> </td> <td> <i onClick="atualiza(${produto.id}, '${produto.nome}', '${produto.especificacao}', '${produto.valor}', ${produto.quantidade})"class="bi bi-pencil-fill"></i> </td> </tr>`
    })
    document.getElementById('corpoTabela').innerHTML = saida // colocando a saida, referente a 'corpoTabela' HTML
}

remove = async () =>{
    let Confirma = confirm(`Confirma a remoção do Produto ${id}`)
    if (Confirma){
        await fetch(`http://localhost:8080/produtos/${id}`, {
            method: 'DELETE'
        })
        .then(Response =>{
            alert(`Remoção Feita com Sucesso`)
        })
        .catch(error =>{
            alert(`Serviço indisponivel`)
        })
        // atualizará a tabela com os pokemon
        consulta()
    }
}

atualiza =(id,nome,especificacao,valor,quantidade) => {
    document.getElementById("id").value = id
    document.getElementById("nome").value = nome
    document.getElementById("especificacao").value = especificacao
    document.getElementById("valor").value = valor
    document.getElementById("quantidade").value = quantidade
}