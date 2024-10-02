##Topic--Multi-Model Classification for Diabetic Retinopathy and Diabetic Foot Ulcer

# Abstract

This project presents a multi-modal deep learning framework for the classification of diabetic retinopathy (DR) and diabetic foot ulcers (DFU), two major complications of diabetes that can lead to severe outcomes if not diagnosed early. Leveraging advanced image processing techniques and deep learning architectures, the system classifies medical images into normal and abnormal categories for both DR and DFU.

The multi-model approach integrates specialized models for each condition:

- A custom MobileNet with a Vision Transformer for DR classification.
- A hybrid ResNet50 with a Vision Transformer for DFU classification.

A binary classification model is implemented to route input images to the appropriate condition-specific model, optimizing diagnostic accuracy. The solution utilizes pre-trained networks and attention mechanisms to enhance feature extraction and improve prediction performance, demonstrating strong generalization across both modalities.

Comprehensive testing and evaluation show the effectiveness of the multi-model system in providing accurate, automated classification, which can assist in early detection and treatment planning.

