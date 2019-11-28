-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Nov 2019 pada 23.29
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_arisrz`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bayar`
--

CREATE TABLE `bayar` (
  `id` int(11) NOT NULL,
  `ket1` text,
  `ket2` text,
  `ket3` text,
  `total` int(11) DEFAULT NULL,
  `bayar` int(11) DEFAULT NULL,
  `kembali` int(11) DEFAULT NULL,
  `kurang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bayar`
--

INSERT INTO `bayar` (`id`, `ket1`, `ket2`, `ket3`, `total`, `bayar`, `kembali`, `kurang`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Cireng = 213x1000', 'Bala - Bala = 213x1000', 'Gehu = 213x1500', 3716000, 4000000, 284000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `id` int(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `akses` varchar(20) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `nis` varchar(18) DEFAULT NULL,
  `kelas` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `akses`, `nama`, `nis`, `kelas`) VALUES
(1, 'admin', 'admin', 'admin', 'awrisceh', NULL, NULL),
(2, 'siswa', 'siswa', 'siswa', 'awrya', '0110203040', 'xii rpl b'),
(3, 'manager', 'manager', 'manager', 'Fiki', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `id_siswa` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `kelas` varchar(20) NOT NULL,
  `gender` varchar(16) NOT NULL,
  `pinjam` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`id_siswa`, `nama`, `jurusan`, `kelas`, `gender`, `pinjam`) VALUES
('2345', 'vbnm', 'Label', 'vbnoj', 'Laki-laki', '29/11/2019'),
('234]87', 'vbnm', 'ANIMASI', 'vbnoj', 'Laki-laki', '29/11/2019');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
