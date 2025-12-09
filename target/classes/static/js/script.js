let personagens = [];
let favoritos = new Set();

async function init() {
    await carregarFavoritos();
    await carregarPersonagens();
    renderizarPersonagensLocais();
}
init();

document.querySelectorAll('.btn-navegacao').forEach(btn => {
    btn.addEventListener('click', () => {
        const secao = btn.dataset.secao;

        document.querySelectorAll('.btn-navegacao')
            .forEach(b => b.classList.remove('ativo'));
        btn.classList.add('ativo');

        document.querySelectorAll('.secao-conteudo')
            .forEach(s => s.classList.remove('ativo'));
        document.getElementById(secao).classList.add('ativo');

        if (secao === 'listar') renderizarPersonagensLocais();
        if (secao === 'favoritos') renderizarFavoritos();
        if (secao === 'api') buscarPersonagensApi();
    });
});

async function carregarPersonagens() {
    const resp = await fetch('/personagens');
    personagens = await resp.json();
}

async function carregarFavoritos() {
    const resp = await fetch('/favoritos');
    const lista = await resp.json();

    favoritos = new Set(lista.map(f => f.personagem.id));
}

document.getElementById('formularioPersonagem').addEventListener('submit', async (e) => {
    e.preventDefault();

    const personagem = {
        nome: document.getElementById('nome').value,
        descricao: document.getElementById('descricao').value,
        urlImagem: document.getElementById('urlImagem').value || null
    };

    await fetch('/personagens', {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(personagem)
    });

    e.target.reset();
    await carregarPersonagens();
    renderizarPersonagensLocais();

    alert("Personagem cadastrado com sucesso!");
});

function renderizarPersonagensLocais(filtro = '') {
    const container = document.getElementById('personagensLocais');

    const filtrados = personagens.filter(p =>
        p.nome.toLowerCase().includes(filtro.toLowerCase()) ||
        p.descricao.toLowerCase().includes(filtro.toLowerCase())
    );

    if (filtrados.length === 0) {
        container.innerHTML = `
            <div class="estado-vazio">
                <h2>Nenhum personagem encontrado</h2>
                <p>Cadastre novos personagens na aba "Cadastrar"</p>
            </div>`;
        return;
    }

    container.innerHTML = filtrados.map(p => `
        <div class="card-personagem">
            <div class="imagem-personagem">
                ${p.urlImagem ? `<img src="${p.urlImagem}" alt="${p.nome}">`
                              : '<span style="color:#ff6b6b;">SEM IMAGEM</span>'}
            </div>

            <h3 class="nome-personagem">${p.nome}</h3>
            <p class="descricao-personagem">${p.descricao}</p>

            <div class="acoes-personagem">
                <button class="btn-acao btn-favorito ${favoritos.has(p.id) ? 'ativo' : ''}"
                        onclick="alternarFavorito(${p.id})">
                    ${favoritos.has(p.id) ? '★ Remover' : '☆ Favorito'}
                </button>

                <button class="btn-acao" onclick="excluirPersonagem(${p.id})">Excluir</button>
            </div>
        </div>
    `).join('');
}

document.getElementById('buscaLocal').addEventListener('input', (e) => {
    renderizarPersonagensLocais(e.target.value);
});

async function alternarFavorito(id) {
    const jaFavoritado = favoritos.has(id);

    if (jaFavoritado) {
        await fetch(`/favoritos/${id}`, { method: "DELETE" });
        favoritos.delete(id);
    } else {
        await fetch(`/favoritos/${id}`, { method: "POST" });
        favoritos.add(id);
    }

    renderizarPersonagensLocais();
    renderizarFavoritos();
}

async function excluirPersonagem(id) {
    if (!confirm("Deseja realmente excluir este personagem?")) return;

    await fetch(`/personagens/${id}`, { method: "DELETE" });

    favoritos.delete(id);
    await carregarPersonagens();
    renderizarPersonagensLocais();
}

function renderizarFavoritos() {
    const container = document.getElementById('personagensFavoritos');
    const personagensFav = personagens.filter(p => favoritos.has(p.id));

    if (personagensFav.length === 0) {
        container.innerHTML = `
            <div class="estado-vazio">
                <h2>Nenhum favorito</h2>
                <p>Adicione personagens aos favoritos</p>
            </div>`;
        return;
    }

    container.innerHTML = personagensFav.map(p => `
        <div class="card-personagem">
            <div class="imagem-personagem">
                ${p.urlImagem ? `<img src="${p.urlImagem}" alt="${p.nome}">`
                              : '<span style="color:#ff6b6b;">SEM IMAGEM</span>'}
            </div>

            <h3 class="nome-personagem">${p.nome}</h3>
            <p class="descricao-personagem">${p.descricao}</p>

            <div class="acoes-personagem">
                <button class="btn-acao btn-favorito ativo"
                        onclick="alternarFavorito(${p.id})">
                    ★ Remover
                </button>
            </div>
        </div>
    `).join('');
}

async function buscarPersonagensApi() {
    const container = document.getElementById('personagensApi');
    const termoBusca = document.getElementById('buscaApi').value;

    await fetch(`/characters`);

    container.innerHTML = filtrados.map(p => `
        <div class="card-personagem">

            <div class="imagem-personagem">
                <span style="color: #ff6b6b;">API CHARACTER</span>
            </div>

            <h3 class="nome-personagem">${p.nome}</h3>
            <p class="descricao-personagem">${p.descricao}</p>

            <div class="acoes-personagem">
                <button class="btn-acao" onclick="importarPersonagem('${p.id}', '${p.nome}', '${p.descricao}')">
                    Importar
                </button>
            </div>
        </div>
    `).join('');
}

async function importarPersonagem(apiId, nome, descricao) {
    await fetch('/personagens', {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            nome: nome,
            descricao: descricao,
            urlImagem: null
        })
    });

    await carregarPersonagens();
    alert("Personagem importado com sucesso!");
}