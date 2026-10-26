# 🎓 Sistem Data dan Nilai Mahasiswa

Program sederhana berbasis konsol yang dibuat menggunakan **Kotlin** untuk mengelola data mahasiswa dan nilai akademik.

Program ini memungkinkan pengguna untuk menambahkan data mahasiswa, memasukkan nilai, menentukan predikat nilai, serta melihat status kelulusan melalui menu interaktif.

Proyek ini dibuat sebagai bagian dari proses belajar pemrograman untuk memahami dasar-dasar Kotlin dan penerapan konsep *Object-Oriented Programming* (OOP).

## ✨ Fitur

- ➕ **Tambah Mahasiswa** — Menambahkan data mahasiswa berupa nama, NIM, dan jurusan.
- 📝 **Input Nilai** — Memasukkan nilai mahasiswa berdasarkan NIM.
- 📊 **Penentuan Predikat** — Mengubah nilai angka menjadi predikat huruf secara otomatis.
- ✅ **Status Kelulusan** — Menentukan apakah mahasiswa lulus berdasarkan nilai yang diperoleh.
- 📋 **Tampilkan Data Mahasiswa** — Menampilkan informasi mahasiswa beserta nilai dan predikatnya.
- 🔒 **Enkapsulasi** — Melindungi data nilai menggunakan properti `private` dan mengaksesnya melalui fungsi.
- 🛡️ **Validasi Input** — Memeriksa kelengkapan data dan memastikan nilai berada dalam rentang 0–100.
- 🔢 **Method Overloading** — Menyediakan dua versi fungsi `setNilai()` untuk menerima tipe data `Int` dan `Double`.
- 📌 **Penyimpanan Data Sementara** — Menampung maksimal lima mahasiswa menggunakan array.
- 🔄 **Menu Interaktif** — Memudahkan pengguna menjalankan berbagai fungsi melalui menu konsol.

## 🛠️ Teknologi yang Digunakan

- **Kotlin** — Bahasa pemrograman utama.
- **Object-Oriented Programming (OOP)** — Pendekatan pemrograman menggunakan kelas dan objek.
- **IntelliJ IDEA** — Lingkungan pengembangan yang digunakan untuk menulis dan menjalankan program.

## 📂 Struktur Proyek

```text
sistem-data-mahasiswa/
├── Main.kt
└── README.md
```

`Main.kt` berisi kelas, fungsi, dan logika utama program.

## 🚀 Cara Menjalankan Program

### Persyaratan

- JDK (Java Development Kit) sudah terpasang.
- Kotlin compiler atau lingkungan pengembangan yang mendukung Kotlin.
- IntelliJ IDEA direkomendasikan untuk menjalankan proyek.

### Langkah-langkah

1. Unduh atau *clone* repository ini:

   ```bash
   git clone URL_REPOSITORY_KAMU
   ```

2. Buka folder proyek menggunakan IntelliJ IDEA.

3. Buka file `Main.kt`.

4. Jalankan fungsi `main()` untuk memulai program.

Jika Kotlin compiler sudah dikonfigurasi, program juga dapat dijalankan melalui terminal:

```bash
kotlinc Main.kt -include-runtime -d SistemMahasiswa.jar
java -jar SistemMahasiswa.jar
```

Sesuaikan nama file jika file Kotlin yang kamu gunakan berbeda.

## 📖 Cara Menggunakan Program

Saat program dijalankan, pengguna akan melihat menu berikut:

```text
===== SISTEM NILAI MAHASISWA =====
1. Tambah mahasiswa
2. Input nilai
3. Tampilkan semua mahasiswa
4. Keluar
Pilih menu:
```

Pilih menu dengan memasukkan angka yang sesuai.

| Menu | Fungsi |
|---|---|
| 1. Tambah mahasiswa | Memasukkan nama, NIM, dan jurusan mahasiswa. |
| 2. Input nilai | Memasukkan nilai mahasiswa berdasarkan NIM. |
| 3. Tampilkan semua mahasiswa | Menampilkan seluruh data mahasiswa yang sudah dimasukkan. |
| 4. Keluar | Mengakhiri program. |

Program dapat menampung maksimal lima mahasiswa dalam satu kali eksekusi.

## 📊 Sistem Penilaian

Program menentukan predikat berdasarkan nilai angka yang dimasukkan.

| Rentang Nilai | Predikat | Status |
|---|---|---|
| 85–100 | A | Lulus |
| 75–84 | B | Lulus |
| 65–74 | C | Lulus |
| 50–64 | D | Belum lulus |
| 0–49 | E | Belum lulus |

Mahasiswa dinyatakan lulus jika memperoleh nilai minimal 65.

## 🧠 Konsep OOP yang Diterapkan

Proyek ini menerapkan beberapa konsep penting dalam *Object-Oriented Programming* (OOP).

### 1. Abstraction (Abstraksi)

Kelas abstrak `Pengguna` menjadi dasar bagi kelas yang mewarisinya. Kelas ini memiliki properti `nama` dan fungsi abstrak `tampilkanIdentitas()` yang harus diimplementasikan oleh kelas turunannya.

### 2. Interface

Interface `BisaDinilai` mendefinisikan fungsi `hitungPredikat()` yang diimplementasikan oleh kelas `Mahasiswa` untuk menentukan predikat nilai.

### 3. Inheritance (Pewarisan)

Kelas `Mahasiswa` mewarisi kelas `Pengguna`, sehingga dapat menggunakan properti `nama` sekaligus memberikan implementasi sendiri untuk fungsi abstrak dari kelas induknya.

### 4. Encapsulation (Enkapsulasi)

Nilai mahasiswa disimpan dalam properti yang bersifat `private`:

```kotlin
private var nilai: Double? = null
```

Nilai tersebut dikelola melalui fungsi `setNilai()` dan diambil menggunakan `ambilNilai()`, sehingga akses terhadap data dapat dikendalikan.

### 5. Polymorphism (Polimorfisme)

Kelas `Mahasiswa` memberikan implementasi terhadap fungsi abstrak dari `Pengguna` dan fungsi yang didefinisikan oleh `BisaDinilai`.

Hal ini menunjukkan bahwa kelas dapat menyediakan perilaku yang spesifik untuk fungsi yang diwarisi atau diimplementasikannya.

## 📚 Konsep Kotlin Lainnya yang Dipelajari

Selain konsep OOP, proyek ini juga menerapkan:

- **Primary Constructor** — Menginisialisasi informasi mahasiswa.
- **Method Overloading** — Membuat beberapa fungsi dengan nama sama tetapi parameter berbeda.
- **Default Arguments** — Memberikan nilai bawaan pada parameter fungsi.
- **Named Arguments** — Memanggil fungsi dengan menyebutkan nama parameternya.
- **Null Safety** — Mengelola nilai yang berpotensi `null` menggunakan tipe nullable dan operator Elvis (`?:`).
- **Array** — Menyimpan objek mahasiswa.
- **Perulangan** — Menggunakan `do-while`, `while`, dan `for`.
- **Percabangan** — Menggunakan `if-else` dan `when`.
- **Function** — Memisahkan logika program ke dalam fungsi-fungsi yang berbeda.
- **Validasi Input** — Memeriksa data kosong dan mengonversi input menjadi angka.

## 🔮 Rencana Pengembangan

Beberapa fitur yang dapat dikembangkan pada versi berikutnya:

- [ ] Menambahkan kapasitas mahasiswa secara dinamis.
- [ ] Mencegah penggunaan NIM yang duplikat.
- [ ] Menambahkan fitur edit data mahasiswa.
- [ ] Menambahkan fitur pencarian berdasarkan nama atau NIM.
- [ ] Menambahkan fitur hapus data mahasiswa.
- [ ] Menyimpan data ke dalam file atau database.
- [ ] Meningkatkan penanganan input yang tidak valid.
- [ ] Memisahkan kelas dan fungsi ke beberapa file Kotlin.

## 🎯 Tujuan Proyek

Proyek ini dibuat untuk:

- Memperkuat pemahaman dasar bahasa Kotlin.
- Mempraktikkan konsep OOP melalui program sederhana.
- Belajar mengorganisasi logika program ke dalam kelas dan fungsi.
- Melatih validasi input dan pengelolaan data.
- Membangun fondasi untuk membuat aplikasi yang lebih kompleks.

## 👨‍💻 Pengembang

**Abyan**

Mahasiswa Informatika yang sedang mempelajari pemrograman dan pengembangan perangkat lunak melalui berbagai proyek sederhana.

---

*Terus belajar, terus berkarya, dan terus berkembang! 🚀*
