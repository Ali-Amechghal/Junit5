-- Table: fft.eligibiliter

-- DROP TABLE fft.eligibiliter;

CREATE TABLE fft.eligibiliter
(
    top_eligibilite boolean,
    top_cotation boolean,
    top_opp_chequier boolean,
    top_revenus_frais boolean,
    top_surendettes boolean,
    top_usage_abusif_carte boolean,
    date_debut_eligibilite date,
    date_fin_eligibilite date,
    top_fragilite_fft boolean,
    id_tiers character varying COLLATE pg_catalog."default" NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.eligibiliter
    OWNER to fft;
    
    
-- Table: fft.oppositions_cheques

-- DROP TABLE fft.oppositions_cheques;

CREATE TABLE fft.oppositions_cheques
(
    id bigint NOT NULL,
    cree_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_creation timestamp without time zone NOT NULL,
    modifie_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modification timestamp without time zone NOT NULL,
    version bigint,
    date_entree date,
    date_sortie date,
    ind_opp_chq integer NOT NULL,
    tiers_id bigint,
    CONSTRAINT oppositions_cheques_pkey PRIMARY KEY (id),
    CONSTRAINT fknwmnevxicpxak1dj36a8pldgk FOREIGN KEY (tiers_id)
        REFERENCES fft.tiers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.oppositions_cheques
    OWNER to fft;
    
-- Table: fft.prestations

-- DROP TABLE fft.prestations;

CREATE TABLE fft.prestations
(
    id bigint NOT NULL,
    cree_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_creation timestamp without time zone NOT NULL,
    modifie_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modification timestamp without time zone NOT NULL,
    version bigint,
    ancien_guichet_apport character varying(5) COLLATE pg_catalog."default",
    cle_client character varying(1) COLLATE pg_catalog."default",
    code_banque character varying(255) COLLATE pg_catalog."default",
    code_guichet character varying(255) COLLATE pg_catalog."default",
    code_produit character varying(3) COLLATE pg_catalog."default",
    code_source character varying(3) COLLATE pg_catalog."default",
    code_sous_produit character varying(3) COLLATE pg_catalog."default",
    date_fin_prestation date,
    date_ouv_prestation date,
    date_transfert date,
    id_prestation character varying(32) COLLATE pg_catalog."default",
    top_sup boolean,
    num_client character varying(255) COLLATE pg_catalog."default",
    num_compte character varying(21) COLLATE pg_catalog."default",
    num_prestation character varying(22) COLLATE pg_catalog."default",
    reseau_distribution character varying(2) COLLATE pg_catalog."default",
    statut_prestation_ap character varying(1) COLLATE pg_catalog."default",
    top_perimetre character varying(1) COLLATE pg_catalog."default",
    code_opt_facturation character varying(255) COLLATE pg_catalog."default",
    date_crea_carte date,
    date_crea_op_fact date,
    date_fin_validite_carte date,
    date_maj_op_fact date,
    date_crea_role_tiers date,
    date_modif_role_tiers date,
    top_supp boolean,
    id_tiers character varying(255) COLLATE pg_catalog."default",
    role_tiers character varying(255) COLLATE pg_catalog."default",
    statut_prestation character varying(1) COLLATE pg_catalog."default",
    top_supp_role_tiers boolean,
    CONSTRAINT prestations_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.prestations
    OWNER to fft;
    
-- Table: fft.tiers

-- DROP TABLE fft.tiers;

CREATE TABLE fft.tiers
(
    id bigint NOT NULL,
    cree_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_creation timestamp without time zone NOT NULL,
    modifie_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modification timestamp without time zone NOT NULL,
    version bigint,
    date_maj_opp_chq date,
    top_sup boolean DEFAULT false,
    guichet_date_maj_opp_chq date,
    guichet_opp_chq boolean,
    guichet_usr_maj_opp_chq character varying(15) COLLATE pg_catalog."default",
    id_tiers character varying(7) COLLATE pg_catalog."default",
    natu_tiers character varying(1) COLLATE pg_catalog."default",
    opp_chq boolean,
    top_banque_prive character varying(3) COLLATE pg_catalog."default",
    top_pp_pm character varying(2) COLLATE pg_catalog."default",
    top_viv_dec character varying(1) COLLATE pg_catalog."default",
    type_tiers character varying(2) COLLATE pg_catalog."default",
    usr_maj_opp_chq character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT tiers_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.tiers
    OWNER to fft;
    
-- Table: fft.relation_tiers_guichets

-- DROP TABLE fft.relation_tiers_guichets;

CREATE TABLE fft.relation_tiers_guichets
(
    id bigint NOT NULL,
    cree_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_creation timestamp without time zone NOT NULL,
    modifie_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modification timestamp without time zone NOT NULL,
    version bigint,
    code_banque character varying(5) COLLATE pg_catalog."default",
    code_guichet character varying(5) COLLATE pg_catalog."default",
    top_sup boolean DEFAULT false,
    id_tiers character varying(7) COLLATE pg_catalog."default",
    nature_lien_pp_pm_cg character varying(2) COLLATE pg_catalog."default",
    num_client character varying(11) COLLATE pg_catalog."default",
    CONSTRAINT relation_tiers_guichets_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.relation_tiers_guichets
    OWNER to fft;
    
-- Table: fft.guichets

-- DROP TABLE fft.guichets;

CREATE TABLE fft.guichets
(
    id bigint NOT NULL,
    cree_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_creation timestamp without time zone NOT NULL,
    modifie_par character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date_modification timestamp without time zone NOT NULL,
    version bigint,
    cd_interdit_guichet_bdf boolean,
    code_banque character varying(255) COLLATE pg_catalog."default",
    code_guichet character varying(255) COLLATE pg_catalog."default",
    guichet_statut integer,
    num_client character varying(255) COLLATE pg_catalog."default",
    top_sup boolean,
    type_cli character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT guichets_pkey PRIMARY KEY (id),
    CONSTRAINT uk65poipivj6ff4ru2jfuse42dk UNIQUE (code_banque, code_guichet, num_client)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE fft.guichets
    OWNER to fft;
    
    
    
