CREATE VIEW champions AS
SELECT * from winner;




CREATE VIEW road_to_final AS
SELECT NUME,Stadiu from tara;



CREATE VIEW result AS
SELECT * from meciuri_eliminatorii;

#AM CREAT ACEST VIEW PENTRU PATRIOTISMUL DE CARE DAU DOVADA FATA DE DRAPEL SI FATA DE VEDETE CARE NE-AU REPREZENTAT
CREATE VIEW romanasii AS
SELECT * from tara where NUME = 'Romania';