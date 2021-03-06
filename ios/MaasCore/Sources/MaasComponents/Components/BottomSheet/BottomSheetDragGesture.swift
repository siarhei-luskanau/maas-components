import SwiftUI

extension BottomSheet {

    var dragGesture: some Gesture {
        DragGesture(coordinateSpace: .local)
            .onChanged(onChanged)
            .onEnded(onEnded)
    }

    private func onChanged(_ value: DragGesture.Value) {

        let yOffset = value.translation.height
        let stiffness = CGFloat(0.2)

        if yOffset > 0 {
            dragOffset = value.translation.height
        }

        let shouldStretchContent = -yOffset + contentBounds.height < UIScreen.main.bounds.height
        if shouldStretchContent {
            dragOffset = yOffset * stiffness
        }
    }

    private func onEnded(_ value: DragGesture.Value) {

        let predictedEndLocation = value.predictedEndLocation.y - value.location.y

        withAnimation(BottomSheetEnvironment.defaultAnimation) {

            switch predictedEndLocation {
            case let position where position > 1:
                dragOffset = 0
                environment.isPresented = false
                environment.onDismiss?()

            case let position where position < 0:
                dragOffset = 0

            default:

                var closestPosition: CGFloat {
                    (predictedEndLocation - topAnchor) < (bottomAnchor - predictedEndLocation)
                        ? topAnchor
                        : bottomAnchor
                }

                dragOffset = 0
                environment.isPresented = closestPosition == topAnchor
                environment.onDismiss?()
            }
        }
    }
}
