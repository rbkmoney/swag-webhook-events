# Payment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Идентификатор платежа | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Дата и время создания | 
**status** | [**StatusEnum**](#StatusEnum) | Статус платежа | 
**error** | [**PaymentError**](PaymentError.md) |  |  [optional]
**amount** | **Long** | Стоимость предлагаемых товаров или услуг, в минорных денежных единицах, например в копейках в случае указания российских рублей в качестве валюты.  | 
**currency** | **String** | Валюта, символьный код согласно [RFC 4217](http://www.iso.org/iso/home/standards/currency_codes.htm).  | 
**metadata** | **Object** | Связанные с платежом метаданные |  [optional]
**paymentToolToken** | **String** | **Deprecated.** _Используйте свойство &#x60;payer&#x60;._ Токен платежного средства, предоставленного плательщиком  |  [optional]
**paymentSession** | **String** | **Deprecated.** _Используйте свойство &#x60;payer&#x60;._ Идентификатор платежной сессии  | 
**contactInfo** | **Object** | **Deprecated.** _Используйте свойство &#x60;payer&#x60;._ Контактные данные плательщика  | 
**ip** | **String** | **Deprecated.** _Используйте свойство &#x60;payer&#x60;._ IP-адрес плательщика  |  [optional]
**fingerprint** | **String** | **Deprecated.** _Используйте свойство &#x60;payer&#x60;._ Уникальный отпечаток user agent&#x27;а плательщика  |  [optional]
**payer** | [**Payer**](Payer.md) |  | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
PROCESSED | &quot;processed&quot;
CAPTURED | &quot;captured&quot;
CANCELLED | &quot;cancelled&quot;
REFUNDED | &quot;refunded&quot;
FAILED | &quot;failed&quot;
