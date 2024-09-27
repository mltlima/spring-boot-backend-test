CREATE TABLE IF NOT EXISTS seg_usuario (
    id_usuario SERIAL PRIMARY KEY,
    nm_usuario VARCHAR(255),
    dt_nascimento DATE,
    cd_cep VARCHAR(9),
    ds_cidade VARCHAR(255),
    cd_uf VARCHAR(2)
);
