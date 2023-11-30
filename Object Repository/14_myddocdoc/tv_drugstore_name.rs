<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>나의 똑닥 > 찜한 약국 > 약국명</description>
   <name>tv_drugstore_name</name>
   <tag></tag>
   <elementGuidId>39225ba7-fea5-4650-bf27-45e77e9c7169</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_drugstore_title</value>
      <webElementGuid>73c08d27-457d-4367-9a90-481d0b6daf71</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>21291e90-86a1-47ab-944b-40636d7651e5</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_drugstore_title' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
