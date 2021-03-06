// Generated by Apple Swift version 5.0.1 (swiftlang-1001.0.82.4 clang-1001.0.46.5)
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wgcc-compat"

#if !defined(__has_include)
# define __has_include(x) 0
#endif
#if !defined(__has_attribute)
# define __has_attribute(x) 0
#endif
#if !defined(__has_feature)
# define __has_feature(x) 0
#endif
#if !defined(__has_warning)
# define __has_warning(x) 0
#endif

#if __has_include(<swift/objc-prologue.h>)
# include <swift/objc-prologue.h>
#endif

#pragma clang diagnostic ignored "-Wauto-import"
#include <Foundation/Foundation.h>
#include <stdint.h>
#include <stddef.h>
#include <stdbool.h>

#if !defined(SWIFT_TYPEDEFS)
# define SWIFT_TYPEDEFS 1
# if __has_include(<uchar.h>)
#  include <uchar.h>
# elif !defined(__cplusplus)
typedef uint_least16_t char16_t;
typedef uint_least32_t char32_t;
# endif
typedef float swift_float2  __attribute__((__ext_vector_type__(2)));
typedef float swift_float3  __attribute__((__ext_vector_type__(3)));
typedef float swift_float4  __attribute__((__ext_vector_type__(4)));
typedef double swift_double2  __attribute__((__ext_vector_type__(2)));
typedef double swift_double3  __attribute__((__ext_vector_type__(3)));
typedef double swift_double4  __attribute__((__ext_vector_type__(4)));
typedef int swift_int2  __attribute__((__ext_vector_type__(2)));
typedef int swift_int3  __attribute__((__ext_vector_type__(3)));
typedef int swift_int4  __attribute__((__ext_vector_type__(4)));
typedef unsigned int swift_uint2  __attribute__((__ext_vector_type__(2)));
typedef unsigned int swift_uint3  __attribute__((__ext_vector_type__(3)));
typedef unsigned int swift_uint4  __attribute__((__ext_vector_type__(4)));
#endif

#if !defined(SWIFT_PASTE)
# define SWIFT_PASTE_HELPER(x, y) x##y
# define SWIFT_PASTE(x, y) SWIFT_PASTE_HELPER(x, y)
#endif
#if !defined(SWIFT_METATYPE)
# define SWIFT_METATYPE(X) Class
#endif
#if !defined(SWIFT_CLASS_PROPERTY)
# if __has_feature(objc_class_property)
#  define SWIFT_CLASS_PROPERTY(...) __VA_ARGS__
# else
#  define SWIFT_CLASS_PROPERTY(...)
# endif
#endif

#if __has_attribute(objc_runtime_name)
# define SWIFT_RUNTIME_NAME(X) __attribute__((objc_runtime_name(X)))
#else
# define SWIFT_RUNTIME_NAME(X)
#endif
#if __has_attribute(swift_name)
# define SWIFT_COMPILE_NAME(X) __attribute__((swift_name(X)))
#else
# define SWIFT_COMPILE_NAME(X)
#endif
#if __has_attribute(objc_method_family)
# define SWIFT_METHOD_FAMILY(X) __attribute__((objc_method_family(X)))
#else
# define SWIFT_METHOD_FAMILY(X)
#endif
#if __has_attribute(noescape)
# define SWIFT_NOESCAPE __attribute__((noescape))
#else
# define SWIFT_NOESCAPE
#endif
#if __has_attribute(warn_unused_result)
# define SWIFT_WARN_UNUSED_RESULT __attribute__((warn_unused_result))
#else
# define SWIFT_WARN_UNUSED_RESULT
#endif
#if __has_attribute(noreturn)
# define SWIFT_NORETURN __attribute__((noreturn))
#else
# define SWIFT_NORETURN
#endif
#if !defined(SWIFT_CLASS_EXTRA)
# define SWIFT_CLASS_EXTRA
#endif
#if !defined(SWIFT_PROTOCOL_EXTRA)
# define SWIFT_PROTOCOL_EXTRA
#endif
#if !defined(SWIFT_ENUM_EXTRA)
# define SWIFT_ENUM_EXTRA
#endif
#if !defined(SWIFT_CLASS)
# if __has_attribute(objc_subclassing_restricted)
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) __attribute__((objc_subclassing_restricted)) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# else
#  define SWIFT_CLASS(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
#  define SWIFT_CLASS_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_CLASS_EXTRA
# endif
#endif

#if !defined(SWIFT_PROTOCOL)
# define SWIFT_PROTOCOL(SWIFT_NAME) SWIFT_RUNTIME_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
# define SWIFT_PROTOCOL_NAMED(SWIFT_NAME) SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_PROTOCOL_EXTRA
#endif

#if !defined(SWIFT_EXTENSION)
# define SWIFT_EXTENSION(M) SWIFT_PASTE(M##_Swift_, __LINE__)
#endif

#if !defined(OBJC_DESIGNATED_INITIALIZER)
# if __has_attribute(objc_designated_initializer)
#  define OBJC_DESIGNATED_INITIALIZER __attribute__((objc_designated_initializer))
# else
#  define OBJC_DESIGNATED_INITIALIZER
# endif
#endif
#if !defined(SWIFT_ENUM_ATTR)
# if defined(__has_attribute) && __has_attribute(enum_extensibility)
#  define SWIFT_ENUM_ATTR(_extensibility) __attribute__((enum_extensibility(_extensibility)))
# else
#  define SWIFT_ENUM_ATTR(_extensibility)
# endif
#endif
#if !defined(SWIFT_ENUM)
# define SWIFT_ENUM(_type, _name, _extensibility) enum _name : _type _name; enum SWIFT_ENUM_ATTR(_extensibility) SWIFT_ENUM_EXTRA _name : _type
# if __has_feature(generalized_swift_name)
#  define SWIFT_ENUM_NAMED(_type, _name, SWIFT_NAME, _extensibility) enum _name : _type _name SWIFT_COMPILE_NAME(SWIFT_NAME); enum SWIFT_COMPILE_NAME(SWIFT_NAME) SWIFT_ENUM_ATTR(_extensibility) SWIFT_ENUM_EXTRA _name : _type
# else
#  define SWIFT_ENUM_NAMED(_type, _name, SWIFT_NAME, _extensibility) SWIFT_ENUM(_type, _name, _extensibility)
# endif
#endif
#if !defined(SWIFT_UNAVAILABLE)
# define SWIFT_UNAVAILABLE __attribute__((unavailable))
#endif
#if !defined(SWIFT_UNAVAILABLE_MSG)
# define SWIFT_UNAVAILABLE_MSG(msg) __attribute__((unavailable(msg)))
#endif
#if !defined(SWIFT_AVAILABILITY)
# define SWIFT_AVAILABILITY(plat, ...) __attribute__((availability(plat, __VA_ARGS__)))
#endif
#if !defined(SWIFT_DEPRECATED)
# define SWIFT_DEPRECATED __attribute__((deprecated))
#endif
#if !defined(SWIFT_DEPRECATED_MSG)
# define SWIFT_DEPRECATED_MSG(...) __attribute__((deprecated(__VA_ARGS__)))
#endif
#if __has_feature(attribute_diagnose_if_objc)
# define SWIFT_DEPRECATED_OBJC(Msg) __attribute__((diagnose_if(1, Msg, "warning")))
#else
# define SWIFT_DEPRECATED_OBJC(Msg) SWIFT_DEPRECATED_MSG(Msg)
#endif
#if __has_feature(modules)
#if __has_warning("-Watimport-in-framework-header")
#pragma clang diagnostic ignored "-Watimport-in-framework-header"
#endif
@import AppKit;
@import Foundation;
@import ObjectiveC;
#endif

#pragma clang diagnostic ignored "-Wproperty-attribute-mismatch"
#pragma clang diagnostic ignored "-Wduplicate-method-arg"
#if __has_warning("-Wpragma-clang-attribute")
# pragma clang diagnostic ignored "-Wpragma-clang-attribute"
#endif
#pragma clang diagnostic ignored "-Wunknown-pragmas"
#pragma clang diagnostic ignored "-Wnullability"

#if __has_attribute(external_source_symbol)
# pragma push_macro("any")
# undef any
# pragma clang attribute push(__attribute__((external_source_symbol(language="Swift", defined_in="KPCTabsControl",generated_declaration))), apply_to=any(function,enum,objc_interface,objc_category,objc_protocol))
# pragma pop_macro("any")
#endif







@class NSCoder;
@class NSMenu;
@class NSEvent;

SWIFT_CLASS("_TtC14KPCTabsControl9TabButton")
@interface TabButton : NSButton
- (nonnull instancetype)initWithFrame:(NSRect)frameRect SWIFT_UNAVAILABLE;
- (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder OBJC_DESIGNATED_INITIALIZER;
- (id _Nonnull)copy SWIFT_WARN_UNUSED_RESULT;
@property (nonatomic, strong) NSMenu * _Nullable menu;
- (void)updateTrackingAreas;
- (void)mouseEntered:(NSEvent * _Nonnull)theEvent;
- (void)mouseExited:(NSEvent * _Nonnull)theEvent;
- (void)mouseDown:(NSEvent * _Nonnull)theEvent;
- (void)resetCursorRects;
- (void)drawRect:(NSRect)dirtyRect;
@end

@protocol TabsControlDataSource;
@protocol TabsControlDelegate;

/// TabsControl is the main class of the library, and is designed to suffice for implementing tabs in your app.
/// The only necessary thing for it to work is an implementation of its <code>dataSource</code>.
SWIFT_CLASS("_TtC14KPCTabsControl11TabsControl")
@interface TabsControl : NSControl <NSTextDelegate>
/// The dataSource of the tabs control, providing all the necessary information for the class to build the tabs.
@property (nonatomic, weak) IBOutlet id <TabsControlDataSource> _Nullable dataSource;
/// The delegate of the tabs control, providing additional possibilities for customization and precise behavior.
@property (nonatomic, weak) IBOutlet id <TabsControlDelegate> _Nullable delegate;
- (nullable instancetype)initWithCoder:(NSCoder * _Nonnull)coder OBJC_DESIGNATED_INITIALIZER;
- (nonnull instancetype)initWithFrame:(NSRect)frameRect OBJC_DESIGNATED_INITIALIZER;
- (NSMenu * _Nullable)menuForEvent:(NSEvent * _Nonnull)event SWIFT_WARN_UNUSED_RESULT;
- (void)observeValueForKeyPath:(NSString * _Nullable)keyPath ofObject:(id _Nullable)object change:(NSDictionary<NSKeyValueChangeKey, id> * _Nullable)change context:(void * _Nullable)context;
- (void)textDidEndEditing:(NSNotification * _Nonnull)notification;
@property (nonatomic, readonly, getter=isOpaque) BOOL opaque;
@property (nonatomic, readonly, getter=isFlipped) BOOL flipped;
- (void)encodeRestorableStateWithCoder:(NSCoder * _Nonnull)coder;
- (void)restoreStateWithCoder:(NSCoder * _Nonnull)coder;
@end


SWIFT_PROTOCOL("_TtP14KPCTabsControl21TabsControlDataSource_")
@protocol TabsControlDataSource <NSObject>
/// Returns the number of tabs
/// \param control The instance of the tabs control.
///
///
/// returns:
/// A unsigned integer indicating the number of tabs to display.
- (NSInteger)tabsControlNumberOfTabs:(TabsControl * _Nonnull)control SWIFT_WARN_UNUSED_RESULT;
/// Return the item for the tab at the given index, similarly to a “representedObject” in a cell view.
/// \param control The instance of the tabs control.
///
/// \param index The index of the given item.
///
///
/// returns:
/// An instance of an object representing the tab.
- (id _Nonnull)tabsControl:(TabsControl * _Nonnull)control itemAtIndex:(NSInteger)index SWIFT_WARN_UNUSED_RESULT;
/// Return the title for the tab of the given item
/// \param control The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// A string to be used as title of the tab.
- (NSString * _Nonnull)tabsControl:(TabsControl * _Nonnull)control titleForItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
@optional
/// If any, returns a menu for the tab, to be place to the right side of it. It is your responsability to fully
/// configure its targets and actions before returning it to the tabs control.
/// \param control The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// A menu instance.
- (NSMenu * _Nullable)tabsControl:(TabsControl * _Nonnull)control menuForItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
/// If any, returns an icon for the tab, to be placed to the left side of it.
/// \param control The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// An image instance for the icon.
- (NSImage * _Nullable)tabsControl:(TabsControl * _Nonnull)control iconForItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
/// If the width of the tab is not large enough to draw the title, it is possible to provide here an alternate
/// icon to replace it. The threshold at which one switch between the title and the icon is computed individually
/// for each title.
/// \param control The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// An image instance for the alternate icon.
- (NSImage * _Nullable)tabsControl:(TabsControl * _Nonnull)control titleAlternativeIconForItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
@end


SWIFT_PROTOCOL("_TtP14KPCTabsControl19TabsControlDelegate_")
@protocol TabsControlDelegate <NSControlTextEditingDelegate>
@optional
/// Determine if the tab can be selected.
/// \param tabControl The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// A boolean value indicating whether the tab can be selected or not.
- (BOOL)tabsControl:(TabsControl * _Nonnull)control canSelectItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
/// If implemented, the delegate is informed that the selected tab did change.
/// See also TabsControlSelectionDidChangeNotification
/// \param tabControl The instance of the tabs control.
///
/// \param item The item representing the selected tab.
///
- (void)tabsControlDidChangeSelection:(TabsControl * _Nonnull)control item:(id _Nonnull)item;
/// Return <code>true</code> if the tab is allowed to be reordered (by being dragged with the mouse).
/// This method has no effect if the one below is not implemented.
/// \param tabControl The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// A boolean value indicating whether the tab can be reordered or not.
- (BOOL)tabsControl:(TabsControl * _Nonnull)control canReorderItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
/// If implemented, the delegate is informed that the tabs have been reordered. It is the delegate responsability
/// to store the new order of items. If not stored, the tabs will recover their original order.
/// \param tabControl The instance of the tabs control.
///
/// \param items The array the items following the new orders.
///
- (void)tabsControl:(TabsControl * _Nonnull)control didReorderItems:(NSArray * _Nonnull)items;
/// Return <code>true</code> if you allow the editing of the title of the tab. By default, titles are not editable.
/// This method has no effect if the one below is not implemented.
/// \param tabControl The instance of the tabs control.
///
/// \param item The item representing the given tab.
///
///
/// returns:
/// A boolean value indicating whether the tab title can be edited or not.
- (BOOL)tabsControl:(TabsControl * _Nonnull)control canEditTitleOfItem:(id _Nonnull)item SWIFT_WARN_UNUSED_RESULT;
/// If implemented, the delegate is informed that the tab has been renamed to the given title. Again, it is the
/// delegate responsability to store the new title.
/// \param tabControl The instance of the tabs control.
///
/// \param newTitle The new title value.
///
/// \param item The item representing the given tab.
///
- (void)tabsControl:(TabsControl * _Nonnull)control setTitle:(NSString * _Nonnull)newTitle forItem:(id _Nonnull)item;
@end

#if __has_attribute(external_source_symbol)
# pragma clang attribute pop
#endif
#pragma clang diagnostic pop
