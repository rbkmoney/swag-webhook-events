# Invoice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Идентификатор инвойса | 
**shopID** | **String** | Идентификатор магазина | 
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | Дата и время создания | 
**status** | [**StatusEnum**](#StatusEnum) | Статус инвойса | 
**reason** | **String** | Причина отмены или погашения инвойса |  [optional]
**dueDate** | [**OffsetDateTime**](OffsetDateTime.md) | Дата и время истечения срока жизни | 
**amount** | **Long** | Стоимость предлагаемых товаров или услуг, в минорных денежных единицах, например в копейках в случае указания российских рублей в качестве валюты.  | 
**currency** | **String** | Валюта, символьный код согласно [RFC 4217](http://www.iso.org/iso/home/standards/currency_codes.htm).  | 
**metadata** | **Object** | Связанные с инвойсом метаданные | 
**product** | **String** | Наименование предлагаемых товаров или услуг | 
**description** | **String** | Описание предлагаемых товаров или услуг |  [optional]
**cart** | [**List&lt;InvoiceCartLine&gt;**](InvoiceCartLine.md) | Корзина с набором позиций продаваемых товаров или услуг  |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
UNPAID | &quot;unpaid&quot;
CANCELLED | &quot;cancelled&quot;
PAID | &quot;paid&quot;
REFUNDED | &quot;refunded&quot;
FULFILLED | &quot;fulfilled&quot;
