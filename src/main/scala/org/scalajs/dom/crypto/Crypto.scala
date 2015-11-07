package org.scalajs.dom.crypto

import java.math.{BigInteger => _}

import org.scalajs.dom.raw._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.`|`
import scala.scalajs.js.typedarray.ArrayBufferView

import org.scalajs.dom.crypto._


@js.native
object GlobalCrypto extends js.GlobalScope {
  val crypto: Crypto = js.native
}

/**
 * The Crypto interface represents basic cryptography features available in the
 * current context. It allows access to a cryptographically strong random
 * number generator and to cryptographic primitives.
 *
 * MDN
 */
@js.native
trait Crypto extends js.Object {
  /**
   * Returns a SubtleCrypto object providing access to common cryptographic
   * primitives, like hashing, signing, encryption or decryption.
   *
   * MDN
   */
  val subtle: SubtleCrypto = js.native

  /**
   * Fills the passed TypedArray with cryptographically sound random values.
   *
   * MDN
   */
  def getRandomValues(array: ArrayBufferView): ArrayBufferView = js.native
}

@js.native
trait Algorithm extends js.Object {
  var name: String = js.native
}

@js.native
trait KeyAlgorithm extends Algorithm

@js.native
trait HashAlgorithm extends Algorithm

object HashAlgorithm {

  private def named(name: String): HashAlgorithm = literal(name=name).asInstanceOf[HashAlgorithm]

  val `SHA-1` = named("SHA-1")
  val `SHA-256` = named("SHA-256")
  val `SHA-384` = named("SHA-384")
  val `SHA-512` = named("SHA-512")
  //todo add others

}


@js.native
trait CryptoKey extends js.Object {
  val `type`: String = js.native

  val extractable: Boolean = js.native

  val algorithm: js.Object = js.native

  val usages: js.Object = js.native
}

@js.native
trait RsaOtherPrimesInfo extends js.Object {
  var r: String = js.native

  var d: String = js.native

  var t: String = js.native
}

@js.native
trait JsonWebKey extends js.Object {
  var kty: String = js.native

  var use: String = js.native

  var key_ops: js.Array[String] = js.native

  var alg: js.Array[String] = js.native

  var ext: Boolean = js.native

  var crv: String = js.native

  var x: String = js.native

  var y: String = js.native

  var d: String = js.native

  var n: String = js.native

  var e: String = js.native

  var p: String = js.native

  var q: String = js.native

  var dp: String = js.native

  var dq: String = js.native

  var qi: String = js.native

  var oth: js.Array[String] = js.native

  var k: String = js.native
}

/**
 * The SubtleCrypto interface represents a set of cryptographic primitives.
 * It is available via the Crypto.subtle properties available in a window
 * context (via Window.crypto).
 *
 * MDN
 */
@js.native
trait SubtleCrypto extends js.Object {
  /**
   * Returns a Promise of the encrypted data corresponding to the clear text,
   * algorithm and key given as parameters.
   *
   * MDN
   */
  def encrypt(algorithm: AlgorithmIdentifier, key: CryptoKey,
      data: BufferSource): Promise[js.Any] = js.native

  /**
   * Returns a Promise of the clear data corresponding to the encrypted text,
   * algorithm and key given as parameters.
   *
   * MDN
   */
  def decrypt(algorithm: AlgorithmIdentifier, key: CryptoKey,
      data: BufferSource): Promise[js.Any] = js.native

  /**
   * Returns a Promise of the signature corresponding to the text, algorithm
   * and key given as parameters.
   *
   * MDN
   */
  def sign(algorithm: AlgorithmIdentifier, key: CryptoKey,
      data: BufferSource): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a Boolean value indicating if the signature given as
   * parameter matches the text, algorithm and key also given as parameters.
   *
   * MDN
   */
  def verify(algorithm: AlgorithmIdentifier, key: CryptoKey, signature: BufferSource,
      data: BufferSource): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a digest generated from the algorithm and text given
   * as parameters.
   *
   * MDN
   */
  def digest(algorithm: AlgorithmIdentifier, data: BufferSource): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a newly generated CryptoKey, for symmetrical
   * algorithms, or a CryptoKeyPair, containing two newly generated keys, for
   * asymmetrical algorithm, that matches the algorithm, the usages and the
   * extractability given as parameters.
   *
   * MDN
   */
  def generateKey(algorithm: AlgorithmIdentifier, extractable: Boolean,
      keyUsages: js.Array[KeyUsages]): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a newly generated CryptoKey derivated from a master
   * key and a specific algorithm given as parameters.
   *
   * MDN
   */
  def deriveKey(algorithm: AlgorithmIdentifier, baseKey: CryptoKey,
      derivedKeyType: AlgorithmIdentifier, extractable: Boolean,
      keyUsages: js.Array[KeyUsages]): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a newly generated buffer of pseudo-random bits
   * derivated from a master key and a specific algorithm given as parameters.
   *
   * MDN
   */
  def deriveBits(algorithm: AlgorithmIdentifier, baseKey: CryptoKey,
      length: Double): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a CryptoKey corresponding to the format, the
   * algorithm, the raw key data, the usages and the extractability given
   * as parameters.
   *
   * MDN
   */
  def importKey(format: KeyFormat, keyData: BufferSource,
      algorithm: AlgorithmIdentifier, extractable: Boolean,
      keyUsages: js.Array[KeyUsages]): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a CryptoKey corresponding to the format, the
   * algorithm, the raw key data, the usages and the extractability given as
   * parameters.
   *
   * MDN
   */
  def importKey(format: KeyFormat, keyData: JsonWebKey,
      algorithm: AlgorithmIdentifier, extractable: Boolean,
      keyUsages: js.Array[KeyUsages]): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a buffer containing the key in the format requested.
   *
   * MDN
   */
  def exportKey(format: KeyFormat, key: CryptoKey): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a wrapped symmetric key for usage (transfer, storage)
   * in unsecure environments. The wrapped buffer returned is in the format
   * given in parameters, and contained the key wrapped by the give wrapping
   * key with the given algorithm.
   *
   * MDN
   */
  def wrapKey(format: KeyFormat, key: CryptoKey, wrappingKey: CryptoKey,
      wrapAlgorithm: AlgorithmIdentifier): Promise[js.Any] = js.native

  /**
   * Returns a Promise of a CryptoKey corresponding to the wrapped key given in
   * parameter.
   *
   * MDN
   */
  def unwrapKey(format: String, wrappedKey: BufferSource,
      unwrappingKey: CryptoKey, unwrapAlgorithm: AlgorithmIdentifier,
      unwrappedKeyAlgorithm: AlgorithmIdentifier, extractable: Boolean,
      keyUsages: js.Array[KeyUsages]): Promise[js.Any] = js.native
}

// RSASSA-PKCS1-v1_5

@js.native
trait RsaKeyGenParams extends KeyAlgorithm {
  var modulusLength: Double = js.native

  var publicExponent: BigInteger = js.native
}

@js.native
object RsaKeyGenParams {
  @inline
  def apply(name: String, modulusLength: Long,
      publicExponent: BigInteger): RsaKeyGenParams = {
    js.Dynamic.literal(name = name, modulusLength = modulusLength.toDouble,
        publicExponent = publicExponent).asInstanceOf[RsaKeyGenParams]
  }
}

@js.native
trait RsaHashedKeyGenParams extends RsaKeyGenParams {
  var hash: HashAlgorithm = js.native
}

@js.native
object RsaHashedKeyGenParams {
  @inline
  def apply( modulusLength: Long,
      publicExponent: BigInteger, hash: HashAlgorithmIdentifier): RsaHashedKeyGenParams = {
    js.Dynamic.literal(name = "RSASSA-PKCS1-v1_5", modulusLength = modulusLength.toDouble,
        publicExponent = publicExponent,
        hash = hash.asInstanceOf[js.Dynamic]).asInstanceOf[RsaHashedKeyGenParams]
  }
}

@js.native
trait RsaKeyAlgorithm extends KeyAlgorithm {
  var modulusLength: Double = js.native

  var publicExponent: BigInteger = js.native
}

@js.native
object RsaKeyAlgorithm {
  @inline
  def apply(name: String, modulusLength: Long,
      publicExponent: BigInteger): RsaKeyAlgorithm = {
    js.Dynamic.literal(name = name, modulusLength = modulusLength.toDouble,
        publicExponent = publicExponent).asInstanceOf[RsaKeyAlgorithm]
  }
}

@js.native
trait RsaHashedKeyAlgorithm extends RsaKeyAlgorithm {
  var hash: HashAlgorithm = js.native
}



@js.native
object RsaHashedKeyAlgorithm {
  @inline
  def apply(name: String, modulusLength: Long,
      publicExponent: BigInteger, hash: HashAlgorithm): RsaHashedKeyAlgorithm = {
    js.Dynamic.literal(name = name, modulusLength = modulusLength.toDouble,
        publicExponent = publicExponent,
        hash = hash).asInstanceOf[RsaHashedKeyAlgorithm]
  }
}

@js.native
trait RsaHashedImportParams extends js.Object with HashAlgorithm {
  var hash: HashAlgorithm = js.native
}

@js.native
object RsaHashedImportParams {
  @inline
  def apply(hash: HashAlgorithm): RsaHashedImportParams =
    js.Dynamic.literal(hash = hash).asInstanceOf[RsaHashedImportParams]
}

// RSA-PSS

@js.native
trait RsaPssParams extends Algorithm {
  var saltLength: Double = js.native
}

@js.native
object RsaPssParams {
  @inline
  def apply(name: String, saltLength: Long): RsaPssParams = {
    js.Dynamic.literal(name = name,
       saltLength = saltLength.toDouble).asInstanceOf[RsaPssParams]
  }
}

// RSA-OAEP

@js.native
trait RsaOaepParams extends Algorithm {
  var label: BufferSource = js.native
}

@js.native
object RsaOaepParams {
  @inline
  def apply(name: String, label: BufferSource): RsaOaepParams = {
    js.Dynamic.literal(name = name,
       label = label).asInstanceOf[RsaOaepParams]
  }
}

// ECDSA

@js.native
trait EcdsaParams extends Algorithm {
  var hash: HashAlgorithmIdentifier = js.native
}

@js.native
object EcdsaParams {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier): EcdsaParams =
    literal(name = name, hash = hash.asInstanceOf[js.Dynamic]).asInstanceOf[EcdsaParams]
}

@js.native
trait EcKeyGenParams extends Algorithm {
  var namedCurve: String = js.native
}

@js.native
object EcKeyGenParams {
  @inline
  def apply(name: String, namedCurve: String): EcKeyGenParams = {
    js.Dynamic.literal(name = name,
       namedCurve = namedCurve).asInstanceOf[EcKeyGenParams]
  }
}

@js.native
trait EcKeyAlgorithm extends KeyAlgorithm {
  var namedCurve: String = js.native
}

@js.native
object EcKeyAlgorithm {
  @inline
  def apply(name: String, namedCurve: String): EcKeyAlgorithm = {
    js.Dynamic.literal(name = name,
        namedCurve = namedCurve).asInstanceOf[EcKeyAlgorithm]
  }
}

@js.native
trait EcKeyImportParams extends KeyAlgorithm {
  var namedCurve: String = js.native
}

@js.native
object EcKeyImportParams {
  @inline
  def apply(name: String, namedCurve: String): EcKeyImportParams = {
    js.Dynamic.literal(name = name,
       namedCurve = namedCurve).asInstanceOf[EcKeyImportParams]
  }
}

// ECDH

@js.native
trait EcdhKeyDeriveParams extends KeyAlgorithm {
  var `public`: CryptoKey = js.native
}

@js.native
object EcdhKeyDeriveParams {
  @inline
  def apply(name: String, `public`: CryptoKey): EcdhKeyDeriveParams = {
    js.Dynamic.literal(name = name,
       `public` = `public`).asInstanceOf[EcdhKeyDeriveParams]
  }
}

// AES-CTR

@js.native
trait AesCtrParams extends Algorithm {
  var counter: BufferSource = js.native

  var length: Short = js.native
}

@js.native
object AesCtrParams {
  @inline
  def apply(name: String, counter: BufferSource,
      length: Short): AesCtrParams = {
    js.Dynamic.literal(name = name, counter = counter,
        length = length).asInstanceOf[AesCtrParams]
  }
}

@js.native
trait AesKeyAlgorithm extends KeyAlgorithm {
  var length: Int = js.native
}

@js.native
object AesKeyAlgorithm {
  @inline
  def apply(name: String, length: Short): AesKeyAlgorithm = {
    js.Dynamic.literal(name = name,
        length = length).asInstanceOf[AesKeyAlgorithm]
  }
}

@js.native
trait AesKeyGenParams extends KeyAlgorithm {
  var length: Int = js.native
}

@js.native
object AesKeyGenParams {
  @inline
  def apply(name: String, length: Short): AesKeyGenParams = {
    js.Dynamic.literal(name = name,
        length = length).asInstanceOf[AesKeyGenParams]
  }
}

@js.native
trait AesDerivedKeyParams extends KeyAlgorithm {
  var length: Int = js.native
}

@js.native
object AesDerivedKeyParams {
  @inline
  def apply(name: String, length: Short): AesDerivedKeyParams = {
    js.Dynamic.literal(name = name,
        length = length).asInstanceOf[AesDerivedKeyParams]
  }
}

// AES-CBC

@js.native
trait AesCbcParams extends Algorithm {
  var iv: BufferSource = js.native
}

@js.native
object AesCbcParams {
  @inline
  def apply(name: String, iv: BufferSource): AesCbcParams =
    js.Dynamic.literal(name = name, iv = iv).asInstanceOf[AesCbcParams]
}

// AES-CMAC

@js.native
trait AesCmacParams extends Algorithm {
  var length: Int = js.native
}

@js.native
object AesCmacParams {
  @inline
  def apply(name: String, length: Int): AesCmacParams = {
    js.Dynamic.literal(name = name,
        length = length).asInstanceOf[AesCmacParams]
  }
}

// AES-GCM

@js.native
trait AesGcmParams extends Algorithm {
  var iv: BufferSource = js.native

  var additionalData: BufferSource = js.native

  var tagLength: Short = js.native
}

@js.native
object AesGcmParams {
  @inline
  def apply(name: String, iv: BufferSource,
      additionalData: BufferSource, tagLength: Short): AesGcmParams = {
    js.Dynamic.literal(name = name, iv = iv,
        additionalData = additionalData,
        tagLength = tagLength).asInstanceOf[AesGcmParams]
  }
}

// AES-CFB

@js.native
trait AesCfbParams extends Algorithm {
  var iv: BufferSource = js.native
}

@js.native
object AesCfbParams {
  @inline
  def apply(name: String, iv: BufferSource): AesCfbParams =
    js.Dynamic.literal(name = name, iv = iv).asInstanceOf[AesCfbParams]
}

// AES-KW

// HMAC

@js.native
trait HmacImportParams extends Algorithm {
  var hash: HashAlgorithmIdentifier = js.native

  var length: Double = js.native
}

@js.native
object HmacImportParams {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier, length: Long): HmacImportParams = {
    js.Dynamic.literal(name = name, hash = hash.asInstanceOf[js.Dynamic],
        length = length.toDouble).asInstanceOf[HmacImportParams]
  }
}

@js.native
trait HmacKeyAlgorithm extends KeyAlgorithm {
  var hash: HashAlgorithmIdentifier = js.native

  var length: Double = js.native
}

@js.native
object HmacKeyAlgorithm {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier, length: Long): HmacKeyAlgorithm = {
    js.Dynamic.literal(name = name, hash = hash.asInstanceOf[js.Dynamic],
        length = length.toDouble).asInstanceOf[HmacKeyAlgorithm]
  }
}

@js.native
trait HmacKeyGenParams extends KeyAlgorithm {
  var hash: HashAlgorithmIdentifier = js.native

  var length: Double = js.native
}

@js.native
object HmacKeyGenParams {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier, length: Long): HmacKeyGenParams = {
    js.Dynamic.literal(name = name, hash = hash.asInstanceOf[js.Dynamic],
        length = length.toDouble).asInstanceOf[HmacKeyGenParams]
  }
}

// Diffie-Hellman

@js.native
trait DhKeyGenParams extends Algorithm {
  var prime: BigInteger = js.native

  var generator: BigInteger = js.native
}

@js.native
object DhKeyGenParams {
  @inline
  def apply(name: String, prime: BigInteger,
      generator: BigInteger): DhKeyGenParams = {
    js.Dynamic.literal(name = name, prime = prime,
        generator = generator).asInstanceOf[DhKeyGenParams]
  }
}

@js.native
trait DhKeyAlgorithm extends KeyAlgorithm {
  var prime: BigInteger = js.native

  var generator: BigInteger = js.native
}

@js.native
object DhKeyAlgorithm {
  @inline
  def apply(name: String, prime: BigInteger,
      generator: BigInteger): DhKeyAlgorithm = {
    js.Dynamic.literal(name = name, prime = prime,
        generator = generator).asInstanceOf[DhKeyAlgorithm]
  }
}

@js.native
trait DhKeyDeriveParams extends Algorithm {
  var `public`: CryptoKey = js.native
}

@js.native
object DhKeyDeriveParams {
  @inline
  def apply(name: String, public: CryptoKey): DhKeyDeriveParams = {
    js.Dynamic.literal(name = name,
        public = public).asInstanceOf[DhKeyDeriveParams]
  }
}

@js.native
trait DhImportKeyParams extends Algorithm {
  var prime: BigInteger = js.native

  var generator: BigInteger = js.native
}

@js.native
object DhImportKeyParams {
  @inline
  def apply(name: String, prime: BigInteger,
      generator: BigInteger): DhImportKeyParams = {
    js.Dynamic.literal(name = name, prime = prime,
        generator = generator).asInstanceOf[DhImportKeyParams]
  }
}

// CONCAT

@js.native
trait ConcatParams extends Algorithm {
  var hash: HashAlgorithmIdentifier = js.native

  var algorithmId: BufferSource = js.native

  var partyUInfo: BufferSource = js.native

  var partyVInfo: BufferSource = js.native

  var publicInfo: BufferSource = js.native

  var privateInfo: BufferSource = js.native
}

@js.native
object ConcatParams {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier, algorithmId: BufferSource,
      partyUInfo: BufferSource, partyVInfo: BufferSource,
      publicInfo: BufferSource, privateInfo: BufferSource): ConcatParams = {
    js.Dynamic.literal(name = name, hash = hash.asInstanceOf[js.Dynamic],
        algorithmId = algorithmId, partyUInfo = partyUInfo,
        partyVInfo = partyVInfo, publicInfo = publicInfo,
        privateInfo = privateInfo).asInstanceOf[ConcatParams]
  }
}

// HKDF-CTR

@js.native
trait HkdfCtrParams extends Algorithm {
  var hash: HashAlgorithmIdentifier = js.native

  var label: BufferSource = js.native

  var context: BufferSource = js.native
}

@js.native
object HkdfCtrParams {
  @inline
  def apply(name: String, hash: HashAlgorithmIdentifier, label: BufferSource,
      context: BufferSource): HkdfCtrParams = {
    js.Dynamic.literal(name = name, hash = hash.asInstanceOf[js.Dynamic], label = label,
        context = context).asInstanceOf[HkdfCtrParams]
  }
}

// PBKDF2

@js.native
trait Pbkdf2Params extends Algorithm {
  var salt: BufferSource = js.native

  var iterations: Double = js.native

  var hash: HashAlgorithmIdentifier = js.native
}

@js.native
object Pbkdf2Params {
  @inline
  def apply(name: String, salt: BufferSource, iterations: Long,
      hash: HashAlgorithmIdentifier): Pbkdf2Params = {
    js.Dynamic.literal(name = name, salt = salt,
        iterations = iterations.toDouble,
        hash = hash.asInstanceOf[js.Dynamic]).asInstanceOf[Pbkdf2Params]
  }
}

@js.native
trait KeyUsages  extends js.Any

object KeyUsages {
  val encrypt    = "encrypt".asInstanceOf[KeyUsages]
  val decrypt    = "decrypt".asInstanceOf[KeyUsages]
  val sign       = "sign".asInstanceOf[KeyUsages]
  val verify     = "verify".asInstanceOf[KeyUsages]
  val deriveKey  = "deriveKey".asInstanceOf[KeyUsages]
  val deriveBits = "deriveBits".asInstanceOf[KeyUsages]
  val wrapKey    = "wrapKey".asInstanceOf[KeyUsages]
  val unwrapKey  = "unwrapKey".asInstanceOf[KeyUsages]
}

@js.native
trait KeyType extends js.Any

object KeyType {
  val public    = "public".asInstanceOf[KeyType]
  val `private` = "private".asInstanceOf[KeyType]
  val secret    = "secret".asInstanceOf[KeyType]
}

@js.native
trait KeyFormat extends js.Any

object KeyFormat {
  /** An unformatted sequence of bytes. Intended for secret keys. */
  val raw   = "raw".asInstanceOf[KeyFormat]
  /** The DER encoding of the PrivateKeyInfo structure from RFC 5208. */
  val pkcs8 = "pkcs8".asInstanceOf[KeyFormat]
  /** The DER encoding of the SubjectPublicKeyInfo structure from RFC 5280. */
  val spki  = "spki".asInstanceOf[KeyFormat]
  /** The key is a JsonWebKey dictionary encoded as a JavaScript object */
  val jwk   = "jwk".asInstanceOf[KeyFormat]

}