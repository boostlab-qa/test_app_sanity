<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
   <description>가족 관리 > 가족 편집 > [주소 입력하기]</description>
   <name>input_adress</name>
   <tag></tag>
   <elementGuidId>ff7f9175-0955-429b-afe0-ed3017d10fea</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>resource-id</name>
      <type>Main</type>
      <value>com.bbros.sayup.debug:id/tv_address_input</value>
      <webElementGuid>5b52f9e9-6be7-4599-bf94-7de6b000c504</webElementGuid>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>${text}</value>
      <webElementGuid>420f40d8-be1a-4c86-9d59-b806678e8c45</webElementGuid>
   </webElementProperties>
   <locator>//*[@resource-id = 'com.bbros.sayup.debug:id/tv_address_input' and (@text = '${text}' or . = '${text}')]</locator>
   <locatorStrategy>XPATH</locatorStrategy>
</MobileElementEntity>
