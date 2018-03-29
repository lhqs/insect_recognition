# 昆虫识别后台程序接口
> 上传昆虫图片，返回相对应的识别结果，包括昆虫名称，昆虫识别的概率，及对应的昆虫相似的图片样张。 

##### 上传图片示例

```
<html>  
  <head>  
      <title>insect_reconition</title>  
  </head>  
  <body>  
    <form action="http://plant.lhqs1314.cn:8086/insect-1.0/api/insect/uploadImage" method="post" enctype="multipart/form-data">  
        <table>  
            <tr>  
                <td width="100" align="right">照片：</td>  
                <td>
                   <input type="file" name="file"/>   
                   <input type="submit">
                </td>  
            </tr>  
        </table>  
    </form>  
  </body>  
</html>  

```
##### 后台返回数据示例

```
{
  "code": 0,
  "message": "success",
  "data": {
    "1": {
      "res": [
        "http://qiniu.lhqs1314.cn/insect/1/acisoma_panorpoides_panorpoides_016.jpeg",
        "http://qiniu.lhqs1314.cn/insect/1/acisoma_panorpoides_panorpoides_022.jpeg",
        "http://qiniu.lhqs1314.cn/insect/1/acisoma_panorpoides_panorpoides_079.jpeg"
      ],
      "rate": "0.805732",
      "descpation": "acisoma_panorpoides_panorpoides"
    },
    "2": {
      "res": [
        "http://qiniu.lhqs1314.cn/insect/58/ictinogomphus_rapax_090.jpeg",
        "http://qiniu.lhqs1314.cn/insect/58/ictinogomphus_rapax_054.jpeg",
        "http://qiniu.lhqs1314.cn/insect/58/ictinogomphus_rapax_014.jpeg"
      ],
      "rate": "0.039127",
      "descpation": "ictinogomphus_rapax"
    },
    "3": {
      "res": [
        "http://qiniu.lhqs1314.cn/insect/67/lyriothemis_elegantissima_058.jpeg",
        "http://qiniu.lhqs1314.cn/insect/67/lyriothemis_elegantissima_081.jpeg",
        "http://qiniu.lhqs1314.cn/insect/67/lyriothemis_elegantissima_020.jpeg"
      ],
      "rate": "0.027186",
      "descpation": "lyriothemis_elegantissima"
    },
    "4": {
      "res": [
        "http://qiniu.lhqs1314.cn/insect/15/brachythemis_contaminata_044.jpeg",
        "http://qiniu.lhqs1314.cn/insect/15/brachythemis_contaminata_051.jpeg",
        "http://qiniu.lhqs1314.cn/insect/15/brachythemis_contaminata_081.jpeg"
      ],
      "rate": "0.010331",
      "descpation": "brachythemis_contaminata"
    },
    "5": {
      "res": [
        "http://qiniu.lhqs1314.cn/insect/28/coralwinged_grasshopper_013.jpeg",
        "http://qiniu.lhqs1314.cn/insect/28/coralwinged_grasshopper_031.jpeg",
        "http://qiniu.lhqs1314.cn/insect/28/coralwinged_grasshopper_006.jpeg"
      ],
      "rate": "0.008717",
      "descpation": "coralwinged_grasshopper"
    }
  }
}
```
