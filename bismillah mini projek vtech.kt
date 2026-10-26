abstract class Pengguna(val nama: String) {
    abstract fun tampilkanIdentitas()
}

interface BisaDinilai {
    fun hitungPredikat(nilai: Double): String
}

class Mahasiswa(
    nama: String,
    val nim: String,
    val jurusan: String
) : Pengguna(nama), BisaDinilai {

    private var nilai: Double? = null

    override fun tampilkanIdentitas() {
        println("Nama   : $nama")
        println("NIM    : $nim")
        println("Jurusan: $jurusan")
    }

    fun setNilai(nilaiBaru: Double) {
        if (nilaiBaru in 0.0..100.0) {
            nilai = nilaiBaru
            println("Nilai berhasil disimpan.")
        } else {
            println("Nilai harus berada di antara 0 dan 100.")
        }
    }

    fun setNilai(nilaiBaru: Int) {
        setNilai(nilaiBaru.toDouble())
    }

    fun ambilNilai(): Double? = nilai

    override fun hitungPredikat(nilai: Double): String {
        return when {
            nilai >= 85 -> "A"
            nilai >= 75 -> "B"
            nilai >= 65 -> "C"
            nilai >= 50 -> "D"
            else -> "E"
        }
    }

    fun tampilkanRingkasan(
        judul: String = "DATA MAHASISWA",
        tampilkanNim: Boolean = true
    ) {
        println("\n--- $judul ---")
        println("Nama: $nama")

        if (tampilkanNim) {
            println("NIM: $nim")
        } else {
            println("NIM: disembunyikan")
        }

        println("Jurusan: $jurusan")

        val nilaiSekarang: Double? = nilai

        val nilaiTampil = nilaiSekarang ?: -1.0

        if (nilaiTampil == -1.0) {
            println("Nilai: Belum diisi")
        } else {
            println("Nilai: $nilaiTampil")
            println("Predikat: ${hitungPredikat(nilaiTampil)}")

            if (nilaiTampil >= 65) {
                println("Status: LULUS")
            } else {
                println("Status: BELUM LULUS")
            }
        }
    }
}

fun bacaTeks(pesan: String, nilaiDefault: String = ""): String {
    print(pesan)

    return readLine()?.trim() ?: nilaiDefault
}

fun bacaAngka(pesan: String, nilaiDefault: Int = 0): Int {
    val teks = bacaTeks(pesan)

    return teks.toIntOrNull() ?: nilaiDefault
}

fun tambahMahasiswa(
    data: Array<Mahasiswa?>,
    jumlah: Int
): Int {
    if (jumlah >= data.size) {
        println("Kapasitas mahasiswa sudah penuh.")
        return jumlah
    }

    val nama = bacaTeks("Masukkan nama: ")
    val nim = bacaTeks("Masukkan NIM: ")
    val jurusan = bacaTeks("Masukkan jurusan: ")

    if (nama.isBlank() || nim.isBlank() || jurusan.isBlank()) {
        println("Data tidak boleh kosong.")
        return jumlah
    }

    data[jumlah] = Mahasiswa(
        nama = nama,
        nim = nim,
        jurusan = jurusan
    )

    println("Mahasiswa berhasil ditambahkan.")
    return jumlah + 1
}

fun inputNilai(data: Array<Mahasiswa?>, jumlah: Int) {
    val nimDicari = bacaTeks("Masukkan NIM mahasiswa: ")

    var i = 0
    var ditemukan = false

    while (i < jumlah && !ditemukan) {
        val mahasiswa = data[i]

        if (mahasiswa?.nim == nimDicari) {
            val nilaiBaru = bacaAngka("Masukkan nilai (0-100): ", -1)

            if (nilaiBaru in 0..100) {
                mahasiswa.setNilai(nilaiBaru)
            } else {
                println("Input nilai tidak valid.")
            }

            ditemukan = true
        }

        i++
    }

    if (!ditemukan) {
        println("Mahasiswa tidak ditemukan.")
    }
}

fun tampilkanSemua(data: Array<Mahasiswa?>, jumlah: Int) {
    if (jumlah == 0) {
        println("Belum ada data mahasiswa.")
        return
    }

    println("\n===== DAFTAR MAHASISWA =====")

    for (i in 0 until jumlah) {
        data[i]?.tampilkanRingkasan(
            judul = "Mahasiswa ke-${i + 1}",
            tampilkanNim = true
        )
    }
}

fun main() {
    val daftarMahasiswa = arrayOfNulls<Mahasiswa>(5)
    var jumlahMahasiswa = 0
    var pilihan: Int

    do {
        println("\n===== SISTEM NILAI MAHASISWA =====")
        println("1. Tambah mahasiswa")
        println("2. Input nilai")
        println("3. Tampilkan semua mahasiswa")
        println("4. Keluar")

        pilihan = bacaAngka(
            pesan = "Pilih menu: ",
            nilaiDefault = -1
        )

        when (pilihan) {
            1 -> {
                jumlahMahasiswa = tambahMahasiswa(
                    data = daftarMahasiswa,
                    jumlah = jumlahMahasiswa
                )
            }

            2 -> inputNilai(
                data = daftarMahasiswa,
                jumlah = jumlahMahasiswa
            )

            3 -> tampilkanSemua(
                data = daftarMahasiswa,
                jumlah = jumlahMahasiswa
            )

            4 -> println("Program selesai. Terima kasih!")

            else -> println("Pilihan tidak valid.")
        }

    } while (pilihan != 4)
}
