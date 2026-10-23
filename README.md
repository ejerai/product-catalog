# product-catalog

REST API katalog produk memakai Spring Boot, Spring Data JPA, dan database H2.
Dibuat untuk mata kuliah Pemrograman Java Web dan Enterprise (PG191).

## Teknologi
- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database (in-memory)
- Maven

## Cara Menjalankan
```bash
./mvnw spring-boot:run
```
Di Windows PowerShell: `.\mvnw.cmd spring-boot:run`

Aplikasi berjalan di `http://localhost:8081`.
H2 Console: `http://localhost:8081/h2-console` (JDBC URL: `jdbc:h2:mem:catalogdb`, user: `sa`, password kosong).

## Endpoint API
| Method | URL | Keterangan |
|---|---|---|
| GET | `/api/products` | Ambil semua produk |
| GET | `/api/products/{id}` | Ambil produk berdasarkan ID |
| POST | `/api/products` | Tambah produk |
| PUT | `/api/products/{id}` | Ubah produk |
| DELETE | `/api/products/{id}` | Hapus produk |
| GET | `/api/products/search?keyword=...` | Cari produk berdasarkan nama |

## Contoh Body (POST)
```json
{
  "id": "PRD-04",
  "name": "Headset Gaming",
  "price": 1000000.0
}
```
