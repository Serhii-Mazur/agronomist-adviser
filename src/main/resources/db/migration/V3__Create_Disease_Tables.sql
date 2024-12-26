CREATE TABLE IF NOT EXISTS public.disease_fhb_corn
(
    id                BIGSERIAL PRIMARY KEY,
    date_time         TIMESTAMP NOT NULL,
    region_id         int       NOT NULL REFERENCES public.regions (id),
    air_temperature   float4    NOT NULL,
    rel_humidity      int4      NOT NULL,
    precipitation     int4      NOT NULL,
    leaf_wetness_time int4      NOT NULL,
    infection_risk    int4      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.disease_gmd_sunflower
(
    id                BIGSERIAL PRIMARY KEY,
    date_time         TIMESTAMP NOT NULL,
    region_id         int       NOT NULL REFERENCES public.regions (id),
    air_temperature   float4    NOT NULL,
    rel_humidity      int4      NOT NULL,
    leaf_wetness_time int4      NOT NULL,
    infection_risk    int4      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.disease_lbh_corn
(
    id                       BIGSERIAL PRIMARY KEY,
    date_time                TIMESTAMP NOT NULL,
    region_id                int       NOT NULL REFERENCES public.regions (id),
    air_temperature          float4    NOT NULL,
    rel_humidity             int4      NOT NULL,
    precipitation            int4      NOT NULL,
    leaf_wetness_time        int4      NOT NULL,
    south_clb_infection_risk int4      NOT NULL,
    north_clb_infection_risk int4      NOT NULL
);

CREATE TABLE IF NOT EXISTS public.disease_pmb_wheat
(
    id                BIGSERIAL PRIMARY KEY,
    date_time         TIMESTAMP NOT NULL,
    region_id         int       NOT NULL REFERENCES public.regions (id),
    air_temperature   float4    NOT NULL,
    solar_radiation   int4      NOT NULL,
    leaf_wetness_time int4      NOT NULL,
    infection_risk    int4      NOT NULL
);
