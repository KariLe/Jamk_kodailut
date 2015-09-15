
--
-- Tietokanta: `ojatko`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `asiakkaat`
--

CREATE TABLE IF NOT EXISTS `asiakkaat` (
  `nimi` varchar(50) NOT NULL,
  `osoite` varchar(100) NOT NULL,
  `puhelin` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `salasana` varchar(15) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `asiakkaat`
--

INSERT INTO `asiakkaat` (`nimi`, `osoite`, `puhelin`, `email`, `salasana`) VALUES
('Aulis Asiakas', 'Asiakkaantie 13', '040-123456', 'aulis.asiakas@jkl.fi', 'huuhaa');


