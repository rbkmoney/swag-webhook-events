# PaymentToolDetailsBankCard

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bin** | **String** | БИН банка-эмитента карты | 
**lastDigits** | **String** | Последние цифры номера карты | 
**cardNumberMask** | **String** | Маскированый номер карты | 
**paymentSystem** | **String** | Платежная система | 
**tokenProvider** | [**TokenProviderEnum**](#TokenProviderEnum) | Провайдер платежных токенов |  [optional]

<a name="TokenProviderEnum"></a>
## Enum: TokenProviderEnum
Name | Value
---- | -----
APPLEPAY | &quot;applepay&quot;
GOOGLEPAY | &quot;googlepay&quot;
SAMSUNGPAY | &quot;samsungpay&quot;
