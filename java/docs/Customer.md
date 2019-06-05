# Customer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Идентификатор плательщика | 
**shopID** | **String** | Идентификатор магазина | 
**status** | [**StatusEnum**](#StatusEnum) | Статус плательщика | 
**contactInfo** | [**ContactInfo**](ContactInfo.md) |  | 
**metadata** | **Object** | Связанные с плательщиком метаданные | 

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
READY | &quot;ready&quot;
UNREADY | &quot;unready&quot;
